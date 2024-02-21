package com.alison.silva.unifacisa.infortec.dto;

import java.util.List;


public record BuyMinDTO(List<ItemProductMinDTO> itens, Long idClient, Double valueBuy) {

}
