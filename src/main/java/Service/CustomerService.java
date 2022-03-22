package Service;

import Dto.CustomerDTO;
import Dto.CustomerFormDTO;

public interface CustomerService {

    CustomerDTO save(CustomerFormDTO body);

    CustomerDTO search(Long id);

    CustomerDTO update(Long id, CustomerFormDTO body);

    void delete(Long id);

}
