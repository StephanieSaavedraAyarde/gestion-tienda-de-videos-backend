package bo.edu.ucb.SakilaBackend.api;
import bo.edu.ucb.SakilaBackend.bl.*;
import bo.edu.ucb.SakilaBackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController()
public class AddressApi {

    AddressBl addressBl;

    @Autowired
    public AddressApi(AddressBl addressBl) {
        this.addressBl = addressBl;
    }

    @GetMapping(value = "/address/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Address> findBytId(@PathVariable(name = "id") Integer id){
        return addressBl.findById(id);
    }
}
