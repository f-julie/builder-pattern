package com.bloomtech.builderpattern.customerordertracker;

import java.time.LocalDate;

public class Order {
    // Define data members
    private Item item; //required
    private String customername; //required
    private String shippingaddress; //required

    private String customeremail;
    private String customerphone;
    private String affiliatecode;

    private String billingaddress; //defaults to shipping address
    private int quantity; //defaults to 1

    private LocalDate orderplaced; //auto-generated




    //Telescoping constructors...
    public Order(Item item, String customername, String shippingaddress, String customeremail, String customerphone, String billingaddress, int quantity, String affiliatecode) {
        this.item = item;
        this.customername = customername;
        this.shippingaddress = shippingaddress;
        this.billingaddress = billingaddress;

        this.customeremail = customeremail;
        this.customerphone = customerphone;

        this.quantity = quantity;
        this.affiliatecode = affiliatecode;
        this.orderplaced = LocalDate.now();
    }

    public Order(Item item, String customername, String shippingaddress, String customeremail, String customerphone, String billingaddress, int quantity) {
        this.item = item;
        this.customername = customername;
        this.shippingaddress = shippingaddress;
        this.billingaddress = billingaddress;

        this.customeremail = customeremail;
        this.customerphone = customerphone;

        this.quantity = quantity;
        this.orderplaced = LocalDate.now();
    }
    public Order(Item item, String customername, String shippingaddress, String customeremail, String customerphone, String billingaddress) {
        this.item = item;
        this.customername = customername;
        this.shippingaddress = shippingaddress;
        this.billingaddress = billingaddress;

        this.customeremail = customeremail;
        this.customerphone = customerphone;

        this.quantity = 1;
        this.orderplaced = LocalDate.now();
    }
    public Order(Item item, String customername, String shippingaddress, String customeremail) {
        this.item = item;
        this.customername = customername;
        this.shippingaddress = shippingaddress;
        this.billingaddress = shippingaddress;

        this.customeremail = customeremail;

        this.quantity = 1;
        this.orderplaced = LocalDate.now();
    }
    public Order(Item item, String customername, String shippingaddress) {
        this.item = item;
        this.customername = customername;
        this.shippingaddress = shippingaddress;
        this.billingaddress = shippingaddress;

        this.quantity = 1;
        this.orderplaced = LocalDate.now();
    }




    //Getters
    public String getCustomername() {
        return customername;
    }
    public String getCustomeremail() {
        return customeremail;
    }
    public String getCustomerphone() {
        return customerphone;
    }
    public String getShippingaddress() {
        return shippingaddress;
    }
    public String getBillingaddress() {
        return billingaddress;
    }
    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getAffiliatecode() {
        return affiliatecode;
    }
    public LocalDate getOrderplaced() {
        return orderplaced;
    }
}
