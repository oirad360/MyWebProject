package soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.ibatis.session.SqlSession;
import models.Customer;
import utils.MyBatisUtil;
import dao.CustomerMapper;

@WebService
public class MySOAPWS {
	@WebMethod
	public int addizione(int a, int b) {
		return a+b;
	}
	@WebMethod
	public int sottrazione(int a, int b) {
		int res = 0;
		if(a>b) res = a-b;
		return res;
	}
	@WebMethod
	public int moltiplicazione(int a, int b) {
		return a*b;
	}
	@WebMethod
	public String saluta(String s) {
		return "ciaoooo "+s;
	}
	@WebMethod
	public Customer getCustomerById(int customer_id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            return mapper.getCustomerById(customer_id);
        }
    }
	@WebMethod
	public List<Customer> getAllCustomers() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            return mapper.getAllCustomers();
        }
    }
	
	@WebMethod
	public List<Customer> getActiveCustomerInStore(boolean active, int store_id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            return mapper.getActiveCustomerInStore(active, store_id);
        }
    }
	
	@WebMethod
	public void insertCustomer(Customer customer) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            System.out.println(customer);
            mapper.insertCustomer(customer);
            session.commit();
        } catch (Exception e){
        	e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            System.out.println(mapper.getActiveCustomerInStore(true,2)); 
        } catch (Exception e){
        	e.printStackTrace();
        }
	}
}