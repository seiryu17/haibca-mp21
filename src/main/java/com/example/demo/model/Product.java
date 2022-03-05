package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Column(name = "idProductCategory")
	private String idProductCategory;

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

    public String getIdProductCategory() {
        return idProductCategory;
    }

    public void setIdProductCategory(String idProductCategory) {
        this.idProductCategory = idProductCategory;
    }

    public String getProductStock() {
        return productStock;
    }

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }

    

    
}
