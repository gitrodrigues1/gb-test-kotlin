package br.com.marcos.inventory.entrypoint.rest

import br.com.marcos.inventory.core.adapter.InventoryAdapter
import br.com.marcos.inventory.entrypoint.dto.InventoryDto
import br.com.marcos.inventory.entrypoint.mapper.InventoryMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/inventory")
class InventoryController(private val inventoryAdapter: InventoryAdapter) {

    @GetMapping()
    fun getInventoryStatus(@RequestParam sku: Int): ResponseEntity<List<InventoryDto>> {
        val inv = inventoryAdapter.getInventoryStatus(sku)
        val response = inv.map { InventoryMapper().toDto(it) }
        return ResponseEntity( response, HttpStatus.OK)
    }

    @PostMapping
    fun createInventory(
        @RequestParam sku: Int,
        @RequestParam quantity: Int,
        @RequestParam warehouseId: Int): ResponseEntity<InventoryDto> {

        val inv = inventoryAdapter.createInventory(sku, quantity, warehouseId)
        return ResponseEntity(InventoryMapper().toDto(inv), HttpStatus.CREATED)
    }

    @PutMapping("/{sku}/{warehouseId}")
    fun updateInventory(@PathVariable sku: Int,
        @PathVariable warehouseId: Int,
        @RequestParam quantity: Int): ResponseEntity<Unit> {

        inventoryAdapter.updateInventory(sku, quantity, warehouseId)
        return ResponseEntity.noContent().build()
    }
}