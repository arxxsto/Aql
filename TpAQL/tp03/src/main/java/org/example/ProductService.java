package org.example;

public class ProductService {
    private ProductApiClient productApiClient;
    public ProductService(ProductApiClient pr) {
        this.productApiClient = pr;
    }
    public Product getProduct(String productId) {
        return productApiClient.getProduct(productId);
    }
}