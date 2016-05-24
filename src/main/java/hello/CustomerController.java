package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/")
public class CustomerController {
    private List<Customer> customers;

    public CustomerController(){
        customers = new ArrayList<>();
        customers.add(new Customer("Jon", "White", 1L));
        customers.add(new Customer("Courtney", "Burns", 2L));
        customers.add(new Customer("Taylor", "White", 3L));
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> getAll(){
        return customers;
    }



}