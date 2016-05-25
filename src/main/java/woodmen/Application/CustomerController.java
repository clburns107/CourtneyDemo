package Woodmen.Application;

import java.util.List;
//import Woodmen.Application.model.Customer;
//import Woodmen.Application.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/")
public class CustomerController {
    CustomerService customerService = new CustomerService();

    @RequestMapping(value = "/customer", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Customer> getCustomers() {
        List<Customer> listOfCustomers = customerService.getAllCustomers();
        return listOfCustomers;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST, headers = "Accept=application/json")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
    }
}