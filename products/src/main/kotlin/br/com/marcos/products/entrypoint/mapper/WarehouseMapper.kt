package br.com.marcos.products.entrypoint.mapper

import br.com.marcos.products.core.model.Warehouse
import br.com.marcos.products.entrypoint.dto.WarehouseDto

class WarehouseMapper {

    fun toModel(dto: WarehouseDto): Warehouse {
        return Warehouse(
            id = dto.id,
            locality = dto.name,
            type = dto.type
        )
    }

    fun toDto(model: Warehouse): WarehouseDto {
        return WarehouseDto(
            id = model.id,
            name = model.locality,
            type = model.type
        )
    }
}