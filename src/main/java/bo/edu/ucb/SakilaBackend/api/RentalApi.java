package bo.edu.ucb.SakilaBackend.api;

import bo.edu.ucb.SakilaBackend.bl.*;
import bo.edu.ucb.SakilaBackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class RentalApi {

    RentalBl rentalBl;

    @Autowired
    public RentalApi(RentalBl rentalBl) {
        this.rentalBl = rentalBl;
    }

    @PostMapping(value = "/rental", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String AddRental(@RequestBody Rental rental){
        return rentalBl.AddRental(rental);
    }

}