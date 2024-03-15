package com.example.addwin.DemoWebAppTest;


import com.example.addwin.DemoWebAppTest.Model.Item;
import com.example.addwin.DemoWebAppTest.Repository.ItemRepository;
import com.example.addwin.DemoWebAppTest.Service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @InjectMocks
    ItemService itemService;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void itemServiceTest(){
        when(itemRepository.findAll())
                .thenReturn(Arrays.asList(new Item(1, "Item-1", 10, 100,0)));
        List<Item> actual = itemService.getItem();
        List<Item> expected = Arrays.asList(new Item(1, "Item-1", 10, 100,1000));
        Assertions.assertEquals(expected.get(0).getTotal(),actual.get(0).getTotal());
    }
}
