package com.hg.service;

import com.github.pagehelper.Page;
import com.hg.pojo.Customer;
import com.hg.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 黄子柠
 * @date 2020/2/24  12:36
 */
public interface CustomerService {

    void create(@Param("customer") Customer customer);

    void delete(int id);

    Customer findById(int id);

    void update(Customer customer);

    List<Customer> findAll();

    public PageBean findByPage(Customer customer, int pageCode, int pageSize);
}
