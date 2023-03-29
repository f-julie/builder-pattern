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

    public Order(Item item, String customername, String shippingaddress, String customeremail, String customerphone, String affiliatecode, String billingaddress, int quantity) {
        this.item = item;
        this.customername = customername;
        this.shippingaddress = shippingaddress;
        this.customeremail = customeremail;
        this.customerphone = customerphone;
        this.affiliatecode = affiliatecode;
        this.billingaddress = billingaddress == null ? shippingaddress : billingaddress;
        this.quantity = quantity == 0 ? 1 : quantity;
    }
}
