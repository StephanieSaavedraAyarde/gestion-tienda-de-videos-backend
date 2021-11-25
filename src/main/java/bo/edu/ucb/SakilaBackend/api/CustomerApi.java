package bo.edu.ucb.SakilaBackend.api;
import bo.edu.ucb.SakilaBackend.bl.*;
import bo.edu.ucb.SakilaBackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController()
public class CustomerApi {

    CustomerBl customerBl;

    @Autowired
    public CustomerApi(CustomerBl customerBl) {
        this.customerBl = customerBl;
    }

    @GetMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> findBytId(@PathVariable(name = "id") Integer id){
        return customerBl.findById(id);
    }

    @PostMapping(value = "/Customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String AddCustomer(@RequestBody Customer customer){
        return customerBl.AddCustomer(customer);
    }
    
}
