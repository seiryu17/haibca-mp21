package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "product")
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name = "productName")
	private String productName;
 
    @Column(name = "productNo")
	private String productNo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProductCategory", referencedColumnName="Id")
    private ProductCategory category;

    @Column(name = "productStock")
	private String productStock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public ProductCategory getCategory() {
		return category;
	}

    public void setCategory(ProductCategory category) {
		this.category = category;
	}

    public String getProductStock() {
        return productStock;
    }

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }

}
