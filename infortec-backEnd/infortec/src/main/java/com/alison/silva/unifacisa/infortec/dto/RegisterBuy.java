package com.alison.silva.unifacisa.infortec.dto;

import java.util.List;

import com.alison.silva.unifacisa.infortec.entities.ItemProduct;

public record RegisterBuy (String emailClient, List<ItemProduct> itens, Double valueBuy){

}
