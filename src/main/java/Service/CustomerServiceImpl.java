package Service;

import Dto.CustomerDTO;
import Dto.CustomerFormDTO;
import Entity.Customer;
import Repository.CustomerRepository;
import Exception.CustomerException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomerDTO save(CustomerFormDTO body) {
        Customer customer = this.repository.save(mapper.map(body, Customer.class));
        return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO search(Long id) {
        Customer customer = this.repository.findById(id)
                .orElseThrow(() -> new CustomerException(404, "NOT_FOUND", "Customer not found"));
        return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO update(Long id, CustomerFormDTO body) {
        Customer customer = this.repository.findById(id)
                .orElseThrow(() -> new CustomerException(404, "NOT_FOUND", "Customer not found"));
        customer.setFirstName(body.getFirstName());
        customer.setLastName(body.getLastName());
        customer.setSex(body.getSex());
        customer.setCpf(body.getCpf());
        customer.setBirthdate(body.getBirthdate());
        customer.setEmail(body.getEmail());
        customer.setPassword(body.getPassword());
        customer.setActive(body.getActive());
        Customer CustomerUpdated = this.repository.save(customer);
        return mapper.map(CustomerUpdated, CustomerDTO.class);
    }

    @Override
    public void delete(Long id) {
            Customer customer = this.repository.findById(id)
                    .orElseThrow(() -> new CustomerException(404, "NOT_FOUND", "Customer not found"));
            this.repository.delete(customer);
    }

}
