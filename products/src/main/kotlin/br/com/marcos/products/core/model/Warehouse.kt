package br.com.marcos.products.core.model

class Warehouse(
    val id: Int,
    val locality: String,
    val type: WarehouseTypeEnum,
) {
}

enum class WarehouseTypeEnum {
    ECOMMERCE,
    PHYSICAL_STORE
}