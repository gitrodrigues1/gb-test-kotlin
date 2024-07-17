package br.com.marcos.products.entrypoint.dto

import br.com.marcos.products.core.model.WarehouseTypeEnum

class WarehouseDto(
    val id: Int,
    val name: String,
    val type: WarehouseTypeEnum,
) {
}