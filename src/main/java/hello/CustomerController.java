package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/customer")
    public String listCustomers(){
        return "List of all the customers";
    }

    @RequestMapping("/customer/1")
    public String customerDetails(){
        return "One of the customers";
    }

}