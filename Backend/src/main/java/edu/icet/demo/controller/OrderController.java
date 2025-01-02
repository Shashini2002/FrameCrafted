package edu.icet.demo.controller;

import edu.icet.demo.dto.Order;
import edu.icet.demo.entity.OrderEntity;
import edu.icet.demo.repository.OrderRepository;
import edu.icet.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService service;
    private final OrderRepository repository;
    @GetMapping("/get-all-order")
    public ResponseEntity<List<Order>> getAll() {
        List<Order> orders = service.getAllOrder();
        if (orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(orders);
        }
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/place-order")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        try {
            service.addOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body("Order created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/track")
    public ResponseEntity<?> trackOrder(@RequestBody Map<String, String> request) {
        String orderId = request.get("orderId");
        String email = request.get("email");

        OrderEntity entity = repository.findById(Integer.valueOf(orderId))
                .orElse(null);

        if (entity != null && email.equals(entity.getEmailAddress())) {
            Map<String, Object> response = new HashMap<>();
            response.put("itemCode", entity.getItemCode());
            response.put("price", entity.getPrice());

            // Map the status code to a readable status message
            String statusMessage = switch (entity.getOrderState()) {
                case "1" -> "Non-Pay";
                case "2" -> "Pending";
                case "3" -> "Processing";
                case "4"-> "Delivering";
                case "5" -> "Delivered";
                default -> "Unknown Status";
            };
            response.put("status", statusMessage);

            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found!");
    }



    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
        try {
            service.deleteOrder(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Order deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update-order")
    public ResponseEntity<String> updateOrder(@RequestBody Order order) {
        try {
            service.updateOrder(order);
            return ResponseEntity.ok("Order updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
