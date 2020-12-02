package com.zking.myba.service;

import com.zking.myba.mapper.OrderMapper;
import com.zking.myba.model.Customer;
import com.zking.myba.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ICustomerServiceTest extends BaseTestCase{
    Customer customer;
    @Autowired
    ICustomerService customerService;
    @Autowired
    OrderMapper orderMapper;
    @Before
    public void setUp() throws Exception {
        customer=new Customer();
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void load() {
        customer.setCustomerId(1);
        Customer load = customerService.load(customer);
        System.out.println(load);
    }

    @Test
    public void insertMany() {
        customer.setCustomerName("旺财");
        customerService.insertMany(customer);

        Order order=new Order();
        order.setOrderNo("p15");
        order.setCid(customer.getCustomerId());
        Order order1=new Order();
        order1.setOrderNo("p16");
        order1.setCid(customer.getCustomerId());
        List<Order> orders=new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        orderMapper.insertOrder(orders);

    }

    @Test
    public void delete() {
     customer.setCustomerId(1);
     orderMapper.delete(customer.getCustomerId());
        int delete = customerService.delete(customer);
        System.out.println(delete);
    }
}