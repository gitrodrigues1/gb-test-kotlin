package br.com.marcos.inventory.entrypoint.dto

import br.com.marcos.inventory.core.model.WarehouseType

class WarehouseDto(
    val id: Int,
    val name: String,
    val type: WarehouseType,
) {
}