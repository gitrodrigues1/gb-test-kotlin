package br.com.marcos.products.entrypoint.mapper

import br.com.marcos.products.core.model.Product
import br.com.marcos.products.entrypoint.dto.InventoryDto
import br.com.marcos.products.entrypoint.dto.ProductRequestDto
import br.com.marcos.products.entrypoint.dto.ProductResponseDto

class ProductMapper {

    fun toModel(dto: ProductRequestDto): Product {
        return Product(sku = dto.sku, name = dto.name)
    }

    fun toDto(model: Product): ProductResponseDto {
        return ProductResponseDto(sku = model.sku, name = model.name)
    }

    fun toDto(model: Product, inventoryList: List<InventoryDto>): ProductResponseDto {
        return ProductResponseDto(
            sku = model.sku,
            name = model.name,
            inventory = inventoryList,
            totalItems = inventoryList.sumOf { it.quantity },
            isMarketable = inventoryList.any { it.quantity > 0 }
        )
    }
}