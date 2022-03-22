package Controller;

import Dto.CustomerDTO;
import Dto.CustomerFormDTO;
import Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping(path = "/v1/users")
    public ResponseEntity<CustomerDTO> save(@RequestBody @Valid CustomerFormDTO body) {
        CustomerDTO customer = this.service.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @GetMapping(path = "v1/users/:{id}")
    public ResponseEntity<CustomerDTO> search(@PathVariable Long id, @RequestBody @Valid CustomerFormDTO body) {
        CustomerDTO customer = this.service.search(id);
        return ResponseEntity.ok(customer);
    }

    @PutMapping(path = "/v1/users/:{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Long id, @RequestBody @Valid CustomerFormDTO body) {
        CustomerDTO customer = this.service.update(id, body);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping(path = "v1/users/:{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
