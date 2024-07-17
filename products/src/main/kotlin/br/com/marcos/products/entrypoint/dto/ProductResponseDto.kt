package br.com.marcos.products.entrypoint.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ProductResponseDto(
    val sku: Int,
    val name: String,
    val inventory: List<InventoryDto>? = null,
    val totalItems: Int? = null,
    val isMarketable: Boolean? = null,
) {
}