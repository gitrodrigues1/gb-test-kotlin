package br.com.marcos.products.entrypoint.rest

import br.com.marcos.products.core.adapter.ProductAdapter
import br.com.marcos.products.entrypoint.dto.InventoryDto
import br.com.marcos.products.entrypoint.dto.ProductRequestDto
import br.com.marcos.products.entrypoint.dto.ProductResponseDto
import br.com.marcos.products.entrypoint.mapper.ProductMapper
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/products")
class ProductController(
    private val productAdapter: ProductAdapter
) {

    @PostMapping
    fun createProoduct(
        @RequestBody dto: ProductRequestDto): ResponseEntity<ProductResponseDto> {
        val product = productAdapter.createProduct(ProductMapper().toModel(dto))
        return ResponseEntity(ProductMapper().toDto(product), HttpStatus.CREATED)
    }

    @PutMapping("/{sku}")
    fun updateProduct(
        @PathVariable sku: Int,
        @RequestBody dto: ProductRequestDto): ResponseEntity<ProductResponseDto> {
        val product = productAdapter.updateProduct(sku, ProductMapper().toModel(dto))
        return ResponseEntity.ok(ProductMapper().toDto(product))
    }

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<ProductResponseDto>> {
        val products = productAdapter.getAllProducts()
        return ResponseEntity.ok(products.map { ProductMapper().toDto(it) })
    }

    @GetMapping("/{sku}")
    fun getProductBySku(@PathVariable sku: Int): ResponseEntity<ProductResponseDto> {
        val product = productAdapter.getProductBySku(sku)
        val inventoryResponse = productAdapter.getInventoryStatus(sku)
        val inventoryDto = ObjectMapper()
            .registerKotlinModule()
            .convertValue(inventoryResponse, object : TypeReference<List<InventoryDto>>() {})

        return ResponseEntity.ok(ProductMapper().toDto(product, inventoryDto))
    }

    @DeleteMapping("/{sku}")
    fun deleteMapping(@PathVariable sku: Int): ResponseEntity<Unit> {
        productAdapter.deleteProduct(sku)
        return ResponseEntity.noContent().build()
    }
}