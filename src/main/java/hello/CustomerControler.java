package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerControler {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@RequestMapping("/{id}")
	public Customer getTopicById(@PathVariable long id) {
		return customerService.getCustomerById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
		customerService.updateCustomer(id, customer);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deleteCustomer(@PathVariable long id) {
		 customerService.deleteCustomer(id);
	}
}
