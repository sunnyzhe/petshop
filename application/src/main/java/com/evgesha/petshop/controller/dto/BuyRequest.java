package com.evgesha.petshop.controller.dto;

import javax.validation.constraints.PositiveOrZero;

public class BuyRequest {
    public String nameTovara;

    @PositiveOrZero
    public int summaDeneg;
}
