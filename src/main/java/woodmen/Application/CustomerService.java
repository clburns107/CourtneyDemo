package Woodmen.Application;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerService {

    static HashMap<Integer,Customer> customerIdMap=getCustomerIdMap();


    public CustomerService() {
        super();

        if(customerIdMap==null)
        {
            customerIdMap=new HashMap<Integer,Customer>();
            // Creating some objects of Customer while initializing
            Customer jenniferCustomer=new Customer("Jennifer", "Aniston", 1);
            Customer mattCustomer=new Customer("Matt", "LeBlanc", 2);
            Customer davidCustomer=new Customer("David", "Schwimer", 3);
            Customer courtneyCustomer=new Customer("Courtney", "Cox", 4);


            customerIdMap.put(1,jenniferCustomer);
            customerIdMap.put(4,mattCustomer);
            customerIdMap.put(3,davidCustomer);
            customerIdMap.put(2,courtneyCustomer);
        }
    }

    public List<Customer> getAllCustomers()
    {
        List<Customer> customers = new ArrayList<Customer>(customerIdMap.values());
        return customers;
    }

    public Customer getCustomer(int id)
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
    public void deleteCustomer(int id)
    {
        customerIdMap.remove(id);
    }

    public static HashMap<Integer, Customer> getCustomerIdMap() {
        return customerIdMap;
    }

    // Utility method to get max id
    public static int getMaxId()
    {   int max=0;
        for (int id:customerIdMap.keySet()) {
            if(max<=id)
                max=id;

        }
        return max;
    }
}