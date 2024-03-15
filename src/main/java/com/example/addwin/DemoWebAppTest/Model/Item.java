package com.example.addwin.DemoWebAppTest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    private int id;
    private String name;
    private int qty;
    private int price;

    @Transient
    private int total;
}
