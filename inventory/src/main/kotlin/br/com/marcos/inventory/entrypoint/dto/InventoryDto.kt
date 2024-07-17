package br.com.marcos.inventory.entrypoint.dto

class InventoryDto (
    val sku: Int,
    var quantity: Int,
    val warehouse: WarehouseDto
){
}