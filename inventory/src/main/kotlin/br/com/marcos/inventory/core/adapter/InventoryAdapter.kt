package br.com.marcos.inventory.core.adapter

import br.com.marcos.inventory.core.exceptions.BusinessLogicException
import br.com.marcos.inventory.core.model.Inventory
import br.com.marcos.inventory.core.port.IInventoryPort
import br.com.marcos.inventory.infrastructure.database.sql.DatabaseInventoryAdapter
import org.springframework.stereotype.Service

@Service
class InventoryAdapter(
    private val databaseInventoryAdapter: DatabaseInventoryAdapter
): IInventoryPort {

    override fun createInventory(sku: Int, quantity: Int, warehouseId: Int): Inventory {
        return databaseInventoryAdapter.createInventory(sku, quantity, warehouseId)
    }

    override fun updateInventory(sku: Int, quantity: Int, warehouseId: Int): Inventory {
        return databaseInventoryAdapter.updateInventory(sku, quantity, warehouseId)
            ?: throw BusinessLogicException("Product/Inventory not found")
    }

    override fun getInventoryStatus(sku: Int): List<Inventory> {
        return databaseInventoryAdapter.getInventoryStatus(sku)
            .ifEmpty { throw BusinessLogicException("Product/Inventory not found")}
    }


}