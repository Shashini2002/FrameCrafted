package edu.icet.demo.controller;

import edu.icet.demo.dto.Order;
import edu.icet.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService service;

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
