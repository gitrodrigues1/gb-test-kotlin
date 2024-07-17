package br.com.marcos.products.core.adapter

import br.com.marcos.products.core.exceptions.BusinessRuleException
import br.com.marcos.products.core.model.Product
import br.com.marcos.products.core.port.IProductPort
import br.com.marcos.products.entrypoint.dto.InventoryDto
import br.com.marcos.products.infrastructure.database.sql.DatabaseProductAdapter
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Service
class ProductAdapter(
    private val databaseProductAdapter: DatabaseProductAdapter): IProductPort {

    override fun createProduct(product: Product): Product {
        return databaseProductAdapter.createProduct(product)
    }

    override fun updateProduct(sku: Int, product: Product): Product {
        return databaseProductAdapter.updateProduct(sku, product)
    }

    override fun getAllProducts(): MutableList<Product> {
        return databaseProductAdapter.getAllProducts()
            ?: mutableListOf()
    }

    override fun getProductBySku(sku: Int): Product {
        return databaseProductAdapter.getProductBySku(sku)
            ?: throw BusinessRuleException("Product not found")
    }

    override fun deleteProduct(sku: Int) {
        if(!databaseProductAdapter.deleteProduct(sku))
            throw BusinessRuleException("Product not found")
    }

    fun getInventoryStatus(sku: Int): List<InventoryDto> {
        val url = "http://localhost:8081/api/inventory?sku=$sku"
        val response = RestTemplate().getForObject<List<InventoryDto>>(url, InventoryDto::class.java)

        return response

    }
}