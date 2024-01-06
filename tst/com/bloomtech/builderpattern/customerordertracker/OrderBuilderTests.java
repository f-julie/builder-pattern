package com.bloomtech.builderpattern.customerordertracker;

import static org.junit.jupiter.api.Assertions.*;

import com.bloomtech.builderpattern.customerordertracker.Item;
import com.bloomtech.builderpattern.customerordertracker.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.time.LocalDate;


public class OrderBuilderTests {

    @Test
    public void instantiateUserWithAllFields_hasValueForEachField()
    {
        LocalDate currentDate = LocalDate.now();
        Order order = Order.builder()
                .withItem(Item.GYM_WEAR)
                .withShippingAddress("123 Street")
                .withBillingAddress("456 Street")
                .withCustomername("test customer")
                .withCustomerEmail("tc@email.com")
                .withAffiliateCode("1234")
                .withQuantity(2)
                .withCustomerPhone("123-456-7890")
                .build();

        //Assert that the order date was placed on the correct day
        assertEquals(currentDate.getDayOfYear(), order.getOrderplaced().getDayOfYear());

        //Assert that properties are correctly instantiated
        assertEquals("test customer", order.getCustomername());

        //Assert that the quantity property's default value is being overwritten
        assertEquals(2, order.getQuantity());
    }

    @Test
    public void instantiateUserWithMissingOptionalFields_returnsValidUserObject()
    {
        String shippingAddress = "123 Street";
        Order order = Order.builder()
                .withItem(Item.GYM_WEAR)
                .withShippingAddress(shippingAddress)
                .withCustomername("test customer")
                .build();

        //Assert that the billing address will default to the shipping address if not provided
        assertEquals(shippingAddress, order.getBillingaddress());

        //Assert that the com.bloomtech.builderpattern.com.bloomtech.builderpattern.customerordertracker.Order object is valid and contains property data
        assertEquals("test customer", order.getCustomername());

        //Assert that quantity will default to 1
        assertEquals(1, order.getQuantity());
    }

    @Test
    public void instantiateUserWithMissingRequiredFields_throwsRuntimeException()
    {
        //Assert that a runtime exception occurs if an com.bloomtech.builderpattern.com.bloomtech.builderpattern.customerordertracker.Order is instantiated without required fields
        assertThrows(RuntimeException.class, ()->{
            Order order = Order.builder()
                    .withCustomername("just a name")
                    .build();
        });
    }

    @Test
    public void introspectOrderClass_hasNoPublicConstructors()
    {
        //Assert our class has no public constructors
        Class userClass = Order.class;

        Constructor[] constructors = userClass.getConstructors();
        assertEquals(constructors.length, 0);
    }

    @Test
    public void introspectUserClass_cannotInstantiateWithoutBuilder_throwsInstantiationException() {
        assertThrows(InstantiationException.class,()->{
            Order.class.newInstance();
        });
    }
}
