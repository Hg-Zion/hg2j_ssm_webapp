package com.hg.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hg.mapper.CustomerMapper;
import com.hg.pojo.Customer;
import com.hg.pojo.PageBean;
import com.hg.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 黄子柠
 * @date 2020/2/24  12:39
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    public void create(Customer customer) {
        customerMapper.create(customer);
    }

    public void delete(int id) {
        customerMapper.delete(id);
    }

    public Customer findById(int id) {
        return customerMapper.findById(id);
    }

    public void update(Customer customer) {
        customerMapper.update(customer);
    }

    public List<Customer> findAll() {
        return customerMapper.findAll();
    }

    public PageBean findByPage(Customer customer, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode, pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<Customer> page = customerMapper.findByPage(customer);

        return new PageBean(pageCode, (int)Math.ceil((double)(page.getTotal() / (double)pageSize)), (int)page.getTotal(), pageSize, page.getResult());
    }
}
