package br.com.marcos.products.infrastructure.database.sql

import br.com.marcos.products.core.exceptions.BusinessLogicException
import br.com.marcos.products.core.model.Product
import org.springframework.stereotype.Repository

@Repository
class DatabaseProductAdapter {

    var products: MutableList<Product> = mutableListOf(
        Product(123456, "Product 1"),
        Product(123455, "Product 2"),
        Product(123454, "Product 3"),
        Product(123453, "Product 4"),
        Product(123452, "Product 5")
    )

    fun createProduct(product: Product): Product {
        products.add(product)
        return product
    }

    fun updateProduct(sku: Int, product: Product): Product {
        val index = products.indexOfFirst { it.sku == sku }
        if (index == -1)
            throw BusinessLogicException("Product not found")

        products[index] = product
        return product
    }

    fun getAllProducts(): MutableList<Product>? {
        return products
    }

    fun getProductBySku(sku: Int): Product? {
        return products.find { p -> p.sku == sku }
    }

    fun deleteProduct(sku: Int): Boolean {
        return products.removeIf { p -> p.sku == sku}
    }
}