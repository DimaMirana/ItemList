package com.example.user.itemlist;

/**
 * Created by USER on 4/5/2017.
 */

public class info {
    private Integer id;
    private String name;
    private String origin;
    private String pkg;
    private Integer quantity;
    private Integer unit_price;
    private Integer total_price;
    private String date;

    public info(Integer id, String name, String origin, String pkg, Integer quantity, Integer unit_price, Integer total_price, String date) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.pkg = pkg;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.total_price = total_price;
        this.date = date;
    }

    public info(String name, String origin, String pkg, Integer quantity, Integer unit_price, Integer total_price, String date) {
        this.name = name;
        this.origin = origin;
        this.pkg = pkg;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.total_price = total_price;
        this.date = date;
    }



    public info(Integer id, String name, String origin, String pkg,Integer quantity, Integer unit_price) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.pkg = pkg;
        this.quantity = quantity;
        this.unit_price = unit_price;

    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public String getPkg() {
        return pkg;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public String getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
