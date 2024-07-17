package br.com.marcos.inventory.core.model

class Warehouse(
    val id: Int,
    val name: String,
    val type: WarehouseType
) {
}

enum class WarehouseType {
    ECOMMERCE,
    PHYSICAL_STORE
}