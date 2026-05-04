package com.cristianperez.revolutionstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_product")
    private Integer codeProduct;

    @NotBlank(message = "The product cannot be empty")
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 characters long")
    @Column(name = "product_name")
    private String productName;


    @NotNull(message = "The price cannot be empty")
    @DecimalMin(value = "0.0", message = "The price cannot be negative.")
    @DecimalMax(value = "670000.0", message = "The price exceeds the permitted limit.")
    @Column(name = "price")
    private Float priceProduct;

    @NotNull(message = "The stock cannot be empty")
    @Min(value = 0, message = "The stock must be greater than or equal to 0")
    @Max(value = 10120, message = "The stock must be less than or equal to 10120.")
    @Column(name = "stock")
    private Integer stockProduct;

    @NotNull(message = "The status cannot be empty")
    @Column(name = "status_product")
    private boolean statusProduct;

    public Integer getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(Integer codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(Integer stockProduct) {
        this.stockProduct = stockProduct;
    }

    public Float getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Float priceProduct) {
        this.priceProduct = priceProduct;
    }

    public boolean isStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(boolean statusProduct) {
        this.statusProduct = statusProduct;
    }
}
