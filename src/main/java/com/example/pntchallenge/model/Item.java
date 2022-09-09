package com.example.pntchallenge.model;

public class Item {


    public Item() {

    }

    public Item(Integer id, String title, String desc, Double price) {
        super();
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.price = price;

    }

    private Integer id;
    private String title;
    private String desc;
    private Double price;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", Title=" + title + ", Description=" + desc + ", Price=" + price + "]";

    }
}