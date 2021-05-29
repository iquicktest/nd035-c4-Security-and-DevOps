package com.example.demo.controllers;

import com.example.demo.model.persistence.*;
import com.example.demo.model.persistence.repositories.*;
import com.example.demo.model.requests.ModifyCartRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;


import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CartControllerTest {
    @InjectMocks
    private CartController cartController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private ItemRepository itemRepository;

    @Test
    void testAddToCart() {
        ModifyCartRequest modifyCartRequest = new ModifyCartRequest("jerry", 1, 1);
        User user = new User();
        user.setUsername("jerry");
        user.setCart(new Cart());
        when(userRepository.findByUsername(any())).thenReturn(user);
        Item item = new Item();
        item.setId(1L);
        item.setDescription("test");
        item.setPrice(new BigDecimal(13));
        item.setName("test");
        when(itemRepository.findById(any())).thenReturn(Optional.of(item));
        ResponseEntity<Cart> cartResponseEntity = cartController.addTocart(modifyCartRequest);
        assertNotNull(cartResponseEntity);
        assertEquals(200, cartResponseEntity.getStatusCodeValue());
    }

    @Test
    void testRemoveFromCart() {
        ModifyCartRequest removeCartRequest = new ModifyCartRequest("jerry", 1, 1);
        User user = new User();
        user.setUsername("jerry");
        user.setCart(new Cart());
        when(userRepository.findByUsername(any())).thenReturn(user);
        Item item = new Item();
        item.setId(1L);
        item.setDescription("test");
        item.setPrice(new BigDecimal(13));
        item.setName("test");
        when(itemRepository.findById(any())).thenReturn(Optional.of(item));
        ResponseEntity<Cart> cartResponseEntity = cartController.removeFromcart(removeCartRequest);
        assertNotNull(cartResponseEntity);
        assertEquals(200, cartResponseEntity.getStatusCodeValue());
    }



}