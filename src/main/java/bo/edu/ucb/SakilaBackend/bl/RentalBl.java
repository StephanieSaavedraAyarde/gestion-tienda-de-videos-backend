package bo.edu.ucb.SakilaBackend.bl;

import bo.edu.ucb.SakilaBackend.dao.RentalDao;
import bo.edu.ucb.SakilaBackend.dto.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentalBl {

    private final RentalDao rentalDao;

    @Autowired
    public RentalBl(RentalDao rentalDao) {
        this.rentalDao = rentalDao;
    }

    public String AddRental(Rental rental) {
        return rentalDao.AddRental(rental);
    }
}
