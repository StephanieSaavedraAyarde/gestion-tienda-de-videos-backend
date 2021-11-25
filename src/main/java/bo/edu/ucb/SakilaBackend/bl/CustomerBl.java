package bo.edu.ucb.SakilaBackend.bl;

import bo.edu.ucb.SakilaBackend.dao.*;
import bo.edu.ucb.SakilaBackend.dto.*;
import bo.edu.ucb.SakilaBackend.exception.SakilaException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerBl {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerBl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public String AddCustomer(Customer customer) {
        return customerDao.AddCustomer(customer);
    }

    public List<Customer> findById(Integer id) {
        if (id == null) {
            throw new SakilaException(403, "Bad request: The id parameter is mandatory and can't be null or empty");
        }
        return customerDao.FindById(id);
    }

}
