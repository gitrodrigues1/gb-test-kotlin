package br.com.marcos.inventory.entrypoint.mapper

import br.com.marcos.inventory.core.model.Warehouse
import br.com.marcos.inventory.entrypoint.dto.WarehouseDto

class WarehouseMapper {

    fun toModel(dto: WarehouseDto): Warehouse {
        return Warehouse(
            id = dto.id,
            name = dto.name,
            type = dto.type
        )
    }

    fun toDto(model: Warehouse): WarehouseDto {
        return WarehouseDto(
            id = model.id,
            name = model.name,
            type = model.type
        )
    }
}