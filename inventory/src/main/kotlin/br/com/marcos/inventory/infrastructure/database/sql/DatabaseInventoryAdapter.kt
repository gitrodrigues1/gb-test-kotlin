package br.com.marcos.inventory.infrastructure.database.sql

import br.com.marcos.inventory.core.model.Inventory
import br.com.marcos.inventory.core.model.Warehouse
import br.com.marcos.inventory.core.model.WarehouseType
import org.springframework.stereotype.Repository

@Repository
class DatabaseInventoryAdapter {

    private var warehouses: MutableList<Warehouse> = mutableListOf(
        Warehouse(1, "RJ01", WarehouseType.ECOMMERCE),
        Warehouse(2, "RJ02", WarehouseType.PHYSICAL_STORE),
        Warehouse(3, "SP01", WarehouseType.ECOMMERCE),
        Warehouse(4, "SP02", WarehouseType.PHYSICAL_STORE),
        Warehouse(5, "MG01", WarehouseType.ECOMMERCE),
        Warehouse(6, "MG02", WarehouseType.PHYSICAL_STORE),
    )

    private var inventory: MutableList<Inventory> = mutableListOf(
        Inventory(123456, 10, warehouses[0]),
        Inventory(123456, 20, warehouses[2]),
        Inventory(123455, 30, warehouses[3]),
        Inventory(123454, 40, warehouses[5]),
    )

    fun createInventory(sku: Int, quantity: Int, warehouseId: Int): Inventory {
        val warehouse = warehouses.find { it.id == warehouseId }
        val newInventory = Inventory(sku, quantity, warehouse!!)
        inventory.add(newInventory)
        return newInventory
    }

    fun updateInventory(sku: Int, qtd: Int, warehouseId: Int): Inventory? {
        var ind = inventory.indexOfFirst { it.sku == sku && it.warehouse.id == warehouseId }
        if (ind != -1) {
            inventory[ind].quantity += qtd
        }
        return inventory[ind]
    }

    fun getInventoryStatus(sku: Int): List<Inventory> {
        return inventory.filter { it.sku == sku }
    }

}