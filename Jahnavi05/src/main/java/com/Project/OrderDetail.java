package com.Project;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    private int orderDetailId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OrderID")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private double price;

	public OrderDetail(int orderDetailId, Order order, Product product, int quantity, double price) {
		super();
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setOrder() {
		// TODO Auto-generated method stub
		
	}

	public void setProduct() {
		// TODO Auto-generated method stub
		
	}

	public void setAttr1(Object attr1) {
		// TODO Auto-generated method stub
		
	}

	public void setAttr2(Object attr2) {
		// TODO Auto-generated method stub
		
	}

	public void setId(int updateId) {
		// TODO Auto-generated method stub
		
	}

	public void setTotalPrice(double newTotalPrice) {
		// TODO Auto-generated method stub
		
	}

	


}
