import com.hg.mapper.CustomerMapper;
import com.hg.mapper.UserMapper;
import com.hg.pojo.Customer;
import com.hg.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄子柠
 * @date 2020/2/23  14:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-beans.xml"})
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void loginTest(){
        int id = 1;
        User user = userMapper.login("abc");
        System.out.println(user);

        Customer customer = new Customer();
        customer.setName("小越");
        customer.setAddress("马家坡");
        customer.setPhone("19090990090");
        customerMapper.create(customer);
    }

    @Test
    public void selectAllTest(){
        List<Customer> customers = customerMapper.findAll();
        System.out.println(customers);
    }
}
