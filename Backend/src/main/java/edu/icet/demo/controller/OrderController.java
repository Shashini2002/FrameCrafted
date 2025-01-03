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
            response.put("emailAddress", entity.getEmailAddress());
            response.put("phoneNumber", entity.getPhoneNumber());
            response.put("address", entity.getAddress());
            response.put("photoUrl", entity.getPhotoUrl());
            response.put("comment", entity.getComment());

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
    @PutMapping("/update-order/{id}")
    public ResponseEntity<Map<String, String>> updateOrder(
            @PathVariable Integer id,
            @RequestBody Map<String, Object> updates) {
        Optional<OrderEntity> optionalOrder = repository.findById(id);

        if (optionalOrder.isPresent()) {
            OrderEntity order = optionalOrder.get();

            if (updates.containsKey("email")) {
                order.setEmailAddress((String) updates.get("email"));
            }
            if (updates.containsKey("phoneNumber")) {
                order.setPhoneNumber((String) updates.get("phoneNumber"));
            }
            if (updates.containsKey("address")) {
                order.setAddress((String) updates.get("address"));
            }
            if (updates.containsKey("photoUrl")) {
                order.setPhotoUrl((String) updates.get("photoUrl"));
            }
            if (updates.containsKey("comments")) {
                order.setComment((String) updates.get("comments"));
            }

            repository.save(order);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Order updated successfully");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Order not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


}
