package br.com.marcos.inventory.core.model

class Inventory(
    val sku: Int,
    var quantity: Int,
    val warehouse: Warehouse,
) {
}