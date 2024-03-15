package com.example.addwin.DemoWebAppTest.WebApp;

import com.example.addwin.DemoWebAppTest.Model.Item;
import com.example.addwin.DemoWebAppTest.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/service-item")
    public List<Item> getItemFromSevice(){
        return itemService.getItem();
    }
}
