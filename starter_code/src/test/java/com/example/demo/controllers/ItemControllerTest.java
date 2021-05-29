package com.example.demo.controllers;

import com.example.demo.model.persistence.Item;
import com.example.demo.model.persistence.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemControllerTest {
    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemRepository itemRepository;

    @Test
    void testGetItems() {
        ResponseEntity<List<Item>> responseEntity = itemController.getItems();
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void testGetItemById() {
        Item item = new Item();
        item.setId(1L);
        Optional<Item> optionalItem = Optional.of(item);
        when(itemRepository.findById(1L)).thenReturn(optionalItem);
        ResponseEntity<Item> itemResponseEntity = itemController.getItemById(1L);
        assertNotNull(itemResponseEntity);
        assertEquals(200, itemResponseEntity.getStatusCodeValue());
    }

}