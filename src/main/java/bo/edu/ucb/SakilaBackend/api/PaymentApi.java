package bo.edu.ucb.SakilaBackend.api;
import bo.edu.ucb.SakilaBackend.bl.*;
import bo.edu.ucb.SakilaBackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public class PaymentApi {

    PaymentBl paymentBl;

    @Autowired
    public PaymentApi(PaymentBl paymentBl) {
        this.paymentBl = paymentBl;
    }

    @PostMapping(value = "/payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String AddPayment(@RequestBody Payment payment){
        return paymentBl.AddPayment(payment);
    }

}