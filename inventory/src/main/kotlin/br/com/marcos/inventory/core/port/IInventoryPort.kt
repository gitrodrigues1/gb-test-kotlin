package br.com.marcos.inventory.core.port

import br.com.marcos.inventory.core.model.Inventory

interface IInventoryPort {

    fun createInventory(sku: Int, quantity: Int, warehouseId: Int): Inventory
    fun updateInventory(sku: Int, quantity: Int, warehouseId: Int): Inventory
    fun getInventoryStatus(sku: Int): List<Inventory>
}