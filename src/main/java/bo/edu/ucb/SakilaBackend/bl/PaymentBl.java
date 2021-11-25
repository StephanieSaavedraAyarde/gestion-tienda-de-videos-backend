package bo.edu.ucb.SakilaBackend.bl;

import bo.edu.ucb.SakilaBackend.dao.PaymentDao;
import bo.edu.ucb.SakilaBackend.dto.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentBl {

    private final PaymentDao paymentDao;

    @Autowired
    public PaymentBl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public String AddPayment(Payment payment) {
        return paymentDao.AddPayment(payment);
    }
}

