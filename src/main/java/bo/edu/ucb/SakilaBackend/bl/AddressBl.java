package bo.edu.ucb.SakilaBackend.bl;

import bo.edu.ucb.SakilaBackend.dao.*;
import bo.edu.ucb.SakilaBackend.dto.*;
import bo.edu.ucb.SakilaBackend.exception.SakilaException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressBl {

    private final AddressDao addressDao;

    @Autowired
    public AddressBl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public List<Address> findById(Integer id) {
        if (id == null) {
            throw new SakilaException(403, "Bad request: The id parameter is mandatory and can't be null or empty");
        }
        return addressDao.FindById(id);
    }

    public String UpdateCustomerAddress(Integer customerId, String address) {
        return addressDao.UpdateCustomerAddress(customerId, address);
    }
}

