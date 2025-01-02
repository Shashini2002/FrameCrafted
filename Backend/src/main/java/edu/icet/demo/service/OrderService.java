package edu.icet.demo.service;

import edu.icet.demo.dto.Order;

import java.util.List;

public interface OrderService {
     void deleteOrder(Integer id);


    List<Order> getAllOrder();
    void addOrder(Order order);

    void updateOrder(Order order);
}
