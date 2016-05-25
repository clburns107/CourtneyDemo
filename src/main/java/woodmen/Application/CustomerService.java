package Woodmen.Application;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

public class CustomerService {

    static HashMap<Long,Customer> customerIdMap=getCustomerIdMap();


    public CustomerService() {
        super();

        if(customerIdMap==null)
        {
            customerIdMap=new HashMap<Long,Customer>();
            // Creating some objects of Customer while initializing
            Customer jenniferCustomer=new Customer("Jennifer", "Aniston", 1L);
            Customer mattCustomer=new Customer("Matt", "LeBlanc", 2L);
            Customer davidCustomer=new Customer("David", "Schwimmer", 3L);
            Customer courtneyCustomer=new Customer("Courtney", "Cox", 4L);
            Customer matthewCustomer=new Customer("Matthew", "Perry", 5L);



            customerIdMap.put(1L,jenniferCustomer);
            customerIdMap.put(2L,mattCustomer);
            customerIdMap.put(3L,davidCustomer);
            customerIdMap.put(4L,courtneyCustomer);
            customerIdMap.put(5L,matthewCustomer);
        }
    }

    public List<Customer> getAllCustomers()
    {
        List<Customer> customers = new ArrayList<Customer>(customerIdMap.values());
        return customers;
    }

    public Customer getCustomer(long id)
    {
        Customer customer= customerIdMap.get(id);
        return customer;
    }
    public Customer addCustomer(Customer customer)
    {
        customer.setId(getMaxId()+1);
        customerIdMap.put(customer.getId(), customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer)
    {
        if(customer.getId()<=0)
            return null;
        customerIdMap.put(customer.getId(), customer);
        return customer;

    }
    public void deleteCustomer(long id)
    {
        customerIdMap.remove(id);
    }

    public static HashMap<Long, Customer> getCustomerIdMap() {
        return customerIdMap;
    }

    // Utility method to get max id
    public static long getMaxId()
    {   long max=0;
        for (long id:customerIdMap.keySet()) {
            if(max<=id)
                max=id;

        }
        return max;
    }
}