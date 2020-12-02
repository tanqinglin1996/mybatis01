package com.zking.myba.service.impl;

import com.zking.myba.mapper.OrderMapper;
import com.zking.myba.model.Order;
import com.zking.myba.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public int deleteByPrimaryKey(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertOrder(List<Order> orders) {
        return orderMapper.insertOrder(orders);
    }

    @Override
    public int delete(Integer cid) {
        return orderMapper.delete(cid);
    }

    @Override
    public List<Order> load(Order order) {
        return orderMapper.load(order);
    }


}
