package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping(value = "/")
public class CustomerController {
    public List<Customer> createCustomerList()
    {
        Customer jenniferCustomer=new Customer("Jennifer", "Aniston", 1L);
        Customer mattCustomer=new Customer("Matt", "LeBlanc", 2L);
        Customer davidCustomer=new Customer("David", "Schwimer", 3L);
        Customer courtneyCustomer=new Customer("Courtney", "Cox", 4L);

        List<Customer> listOfCustomers = new ArrayList<Customer>();
        listOfCustomers.add(jenniferCustomer);
        listOfCustomers.add(mattCustomer);
        listOfCustomers.add(davidCustomer);
        listOfCustomers.add(courtneyCustomer);
        return listOfCustomers;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> getCustomers()
    {
        List<Customer> listOfCustomers = new ArrayList<Customer>();
        listOfCustomers=createCustomerList();
        return listOfCustomers;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable long id) {
        List<Customer> listOfCustomers = new ArrayList<Customer>();
        listOfCustomers = createCustomerList();

        for (Customer customer : listOfCustomers) {
            if (customer.getId() == id)
                return customer;
        }
        return null;
    }
}