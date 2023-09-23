package rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.ibatis.session.SqlSession;

import dao.CustomerMapper;
import models.Customer;
import utils.MyBatisUtil;

@Path("/")
public class MyRESTWS {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, World!";
    }
    
    @GET
    @Path("/getCustomerById/{customer_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(@PathParam("customer_id") int customer_id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            return mapper.getCustomerById(customer_id);
        }
    }

    @GET
    @Path("/getAllCustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            return mapper.getAllCustomers();
        }
    }
    
    @GET
    @Path("/getActiveCustomersInStore")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getActiveCustomersInStore(
        @QueryParam("active") boolean active,
        @QueryParam("store_id") int store_id) {
        
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            return mapper.getActiveCustomerInStore(active, store_id);
        }
    }
    
    @POST
    @Path("/insertCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertCustomer(Customer customer) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            mapper.insertCustomer(customer);
            session.commit();

            return Response.status(Response.Status.CREATED)
                           .entity("Customer created successfully")
                           .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Failed to create customer")
                           .build();
        }
    }
    
}