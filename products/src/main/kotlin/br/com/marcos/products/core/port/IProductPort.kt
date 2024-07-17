package br.com.marcos.products.core.port

import br.com.marcos.products.core.model.Product

interface IProductPort {

    fun createProduct(product: Product): Product
    fun updateProduct(sku: Int, product: Product): Product
    fun getAllProducts(): MutableList<Product>
    fun getProductBySku(sku: Int): Product
    fun deleteProduct(sku: Int)
}