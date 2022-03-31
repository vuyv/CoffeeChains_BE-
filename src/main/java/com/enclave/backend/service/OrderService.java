package com.enclave.backend.service;

import com.enclave.backend.dto.OrderDTO;
import com.enclave.backend.entity.Order;

import java.util.List;

public interface OrderService {

    Order createNewOrder(OrderDTO orderDTO);


    Order findOrderById(String id);

    Order findOrderByOrdinalNumber(int ordinalNumber);

//    double calculateTotal(Order order);

    Order cancelOrder(Order order);

    boolean isValidTotal(OrderDTO orderDTO, double total);

    List<Order> getOrders();
}
