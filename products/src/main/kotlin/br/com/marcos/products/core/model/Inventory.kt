package br.com.marcos.products.core.model

class Inventory(
    val sku: Int,
    var quantity: Int,
    val warehouse: Warehouse,) {
}