package com.Project;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Products")

public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productID;
    
    @ManyToMany
    @JoinTable(
        name = "Product_Category_Association",
        joinColumns = @JoinColumn(name = "productID"),
        inverseJoinColumns = @JoinColumn(name = "categoryID")
    )
    private List<Category> categories;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private double price;

    @Column(name = "StockQuantity")
    private int stockQuantity;

    // Constructors, getters, and setters
    // Getters and setters
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

	public void setCategoryID(int categoryID) {
		// TODO Auto-generated method stub
		
	}
}
  

