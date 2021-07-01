package com.evgesha.petshop.controller;

import com.evgesha.petshop.animal.dog.Shpitz;
import com.evgesha.petshop.controller.dto.BuyRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("api/shop")
@Validated
public class ShopController {
    Map<String, Shpitz> shpitzStore = new HashMap<>();
    Map<String, List<String>> orderStore = new HashMap<>();


    static HashMap<String, Integer> priceStore = new HashMap<>();

    static {
        priceStore.put("Kormushka", 11);
        priceStore.put("Igrushka", 91);
        priceStore.put("Poilka", 61);
        priceStore.put("Durilka", 71);
    }

    static Set<String> assortiment = priceStore.keySet();

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

    /*
     - создать контрллер GET buy, в который будет приходить от пользователя в json формате имя товара и сумма денег, которую он готов отдать за этот товар
     - на твоей стороне должен быть мэп соответствием "название товара" - "стоимость товара"
     - ты проверяешь, хватает ли у пользователя денег на этот товар и выводишь ответы:
         - все ОК, держи товар ТОВАР
         - все ОК, держи товар ТОВАР, и ты дал больше - держи сдачу N
         - не хватает денег
         - такого товара нет
    */
    @GetMapping("buy")
    public String buyTheShpitzThings(@RequestBody @Valid BuyRequest buyRequest) {
        Integer expectedPrice = priceStore.get(buyRequest.nameTovara);

        if (expectedPrice != null) {
            if (buyRequest.summaDeneg == expectedPrice) {
                return "все ОК, держи товар " + buyRequest.nameTovara;
            } else if (buyRequest.summaDeneg > expectedPrice) {
                int sdacha = buyRequest.summaDeneg - expectedPrice;
                return "все ОК, держи товар " + buyRequest.nameTovara + " и ты дал больше - держи сдачу " + sdacha;
            } else {
                return "ты нищий не хватает денег";
            }
        } else {
            return "такого товара нет";
        }
    }
}