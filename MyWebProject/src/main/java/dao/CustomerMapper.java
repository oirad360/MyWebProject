package dao;
import models.Customer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int customerId);
    void insertCustomer(Customer customer);
    List<Customer> getActiveCustomerInStore(@Param("active") boolean active, @Param("store_id") int store_id);
    //void updateCustomer(Customer customer);
    //void deleteCustomer(int id);
}