package com.hg.mapper;

import com.github.pagehelper.Page;
import com.hg.pojo.Customer;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author 黄子柠
 * @date 2020/2/24  11:39
 */
public interface CustomerMapper {

    void create(@Param("customer") Customer customer);

    void delete(int id);

    Customer findById(int id);

    void update(Customer customer);

    List<Customer> findAll();

    Page<Customer> findByPage(Customer customer);
}
