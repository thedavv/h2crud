package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
		List<Customer> customer = new ArrayList<>();
		customerRepository.findAll()
				.forEach(customer::add);
		return customer;
	}
	
	public Customer getCustomerById(long id){
		return customerRepository.findOne(id);
	}
	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void updateCustomer(long id, Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(long id) {
		customerRepository.delete(id);
	}
}
