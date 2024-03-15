package com.example.addwin.DemoWebAppTest.Service;

import com.example.addwin.DemoWebAppTest.Model.Item;
import com.example.addwin.DemoWebAppTest.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    public List<Item> getItem() {
        List<Item> items = itemRepository.findAll();

        for(Item item:items){
            item.setTotal(item.getQty()*item.getPrice());
        }
        return items;
    }
}
