package com.evgesha.petshop.controller;

import com.evgesha.petshop.animal.dog.Shpitz;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/shop")
public class ShopController {
    Map<String, Shpitz> shpitzStore = new HashMap<>();
    Map<String, List<String>> orderStore = new HashMap<>();

    List<String> assortiment = List.of(
            "Kormushka",
            "Igrushka",
            "Poilka",
            "Durilka"
    );


    @PostMapping("enter")
    public String enterTheShop(@RequestBody Shpitz shpitz) {
        shpitzStore.put(shpitz.name, shpitz);
        return "Welcome with dog=" + shpitz;
    }

    @GetMapping("exit")
    public String exitTheShop(@RequestBody String name) {
        if (name == null || name.length() == 0) {
            return "Nafig, ti nichego ne pronosil";
        } else {
            Shpitz shpitz = shpitzStore.get(name.trim());

            if (shpitz == null) {
                return "Nafig, ti moshennik";
            } else {
                shpitzStore.remove(name.trim());
                return "See your later with dog=" + shpitz;
            }
        }
    }

    @PostMapping("order")
    public String order(@RequestBody List<String> orderList) {
        for (int i = 0; i < orderList.size(); i++) {
            String order = orderList.get(i);

            if (!assortiment.contains(order)) {
                throw new RuntimeException("Unknown order");
            }
        }

        String id = UUID.randomUUID().toString();

        orderStore.put(id, orderList);

        return id;
    }

    @GetMapping("order")
    public List<String> checkOrder(@RequestBody String orderId) {
        return orderStore.get(orderId);
    }
}