package com.zking.myba.service;

import com.zking.myba.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceTest extends BaseTestCase{

    private Order order;
    @Autowired
    private IOrderService orderService;

    @Before
    public void setUp() throws Exception {
        order=new Order();
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
    public void insertOrder() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void load() {
        order.setCid(2);
        List<Order> a = orderService.load(order);
        for (Order order1 : a) {
            System.out.println(order1);
        }
    }
}