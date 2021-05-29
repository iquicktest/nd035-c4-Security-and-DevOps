package com.example.demo.controllers;

import com.example.demo.model.persistence.*;
import com.example.demo.model.persistence.repositories.OrderRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
    @InjectMocks
    OrderController orderController;

    @Mock
    UserRepository userRepository;

    @Mock
    OrderRepository orderRepository;

    @Test
    void testOrderSubmit() {
        User user = new User();
        Cart cart = new Cart();
        Item item = new Item();
        item.setName("hello");
        cart.setItems(Collections.singletonList(item));
        user.setCart(cart);
        when(userRepository.findByUsername("hello")).thenReturn(user);
        ResponseEntity<UserOrder> submit = orderController.submit("hello");
        assertNotNull(submit);
        assertEquals(200, submit.getStatusCodeValue());
    }

    @Test
    void testGetOrderForUser() {
        User user = new User();
        when(userRepository.findByUsername("hello")).thenReturn(user);
        ResponseEntity<List<UserOrder>> ordersForUserResp = orderController.getOrdersForUser("hello");
        assertNotNull(ordersForUserResp);
        assertEquals(200, ordersForUserResp.getStatusCodeValue());
    }


}