package com.hg.controller;

import com.hg.pojo.Customer;
import com.hg.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 黄子柠
 * @date 2020/2/24  12:41
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    /**
     * 跳转到添加客户功能页面
     */
    @RequestMapping("/toSavePage")
    public String toSavePage() {
        return "save";
    }

    /**
     * 跳转到客户列表页面
     */
    @RequestMapping("/toListPage")
    public String toListPage() {
        return "redirect:findByPage.do";
    }

    /**
     * 保存用户信息
     *
     * @param customer
     * @param model
     * @return
     */
    @RequestMapping(value = "/save")
    public String create(Customer customer, Model model) {
        try {
            customerService.create(customer);
            model.addAttribute("message", "保存客户信息系成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "info";
    }

    /**
     * 根据id删除用户信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam int id, Model model) {
        try {
            customerService.delete(id);
            model.addAttribute("message", "删除客户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "info";
    }

    /**
     * 根据id返回客户信息
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findById")
    public Customer findById(@RequestBody Customer customer) {
        Customer customer_info = customerService.findById(customer.getId());
        if (customer_info != null) {
            return customer_info;
        } else {
            return null;
        }
    }

    /**
     * 更新客户信息
     * @param customer
     * @param model
     * @return
     */
    @RequestMapping(value = "/update")
    public String update(Customer customer, Model model) {
        try {
            customerService.update(customer);
            model.addAttribute("message", "更新客户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "info";
    }

    @RequestMapping("/findByPage")
    public String findByPage(Customer customer,
                             @RequestParam(value = "pageCode", required = false, defaultValue = "1") int pageCode,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize,
                             Model model) {
        // 回显数据
        model.addAttribute("page", customerService.findByPage(customer, pageCode, pageSize));
        return "list";
    }
}
