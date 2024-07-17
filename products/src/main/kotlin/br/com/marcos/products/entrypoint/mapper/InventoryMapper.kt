package br.com.marcos.products.entrypoint.mapper

import br.com.marcos.products.core.model.Inventory
import br.com.marcos.products.entrypoint.dto.InventoryDto

class InventoryMapper {

    fun toModel(dto: InventoryDto): Inventory {
        return Inventory(
            sku = dto.sku,
            quantity = dto.quantity,
            warehouse =  WarehouseMapper().toModel(dto.warehouse)
        )
    }

    fun toDto(model: Inventory): InventoryDto {
        return InventoryDto(
            sku = model.sku,
            quantity = model.quantity,
            warehouse = WarehouseMapper().toDto(model.warehouse)
        )
    }
}