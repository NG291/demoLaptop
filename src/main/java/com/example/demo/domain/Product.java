package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty(message = "Tên sản phẩm không được để trống!")
    private String name;

    @NotNull
    @Min(value = 1, message = "Giá sản phẩm phải lớn hơn 0!")
    private double price;

    @NotNull
    @NotEmpty(message = "DetailDesc không được để trống!")
    private String detailDesc;

    @NotNull
    @NotEmpty(message = "ShortDesc không được để trống!")
    private String shortDesc;

    @NotNull
    @Min(value = 1, message = "Số lượng cần lớn hơn hoặc bằng 1!")
    private long quantity;

    private long sold;
    private String factory;
    private String target;
    private String image;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getFactory() {
        return factory;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getTarget() {
        return target;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

}