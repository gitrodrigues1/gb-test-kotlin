package br.com.marcos.products.entrypoint.dto

import com.fasterxml.jackson.annotation.JsonProperty

class InventoryDto(
    @JsonProperty("sku")val sku: Int,
    @JsonProperty("quantity")var quantity: Int,
    @JsonProperty("warehouse")val warehouse: WarehouseDto,

) {
}