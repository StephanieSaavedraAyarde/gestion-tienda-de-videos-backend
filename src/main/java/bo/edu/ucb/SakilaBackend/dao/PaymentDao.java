package bo.edu.ucb.SakilaBackend.dao;

import bo.edu.ucb.SakilaBackend.dto.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class PaymentDao {
    private DataSource dataSource;

    @Autowired
    public PaymentDao (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String AddPayment(Payment payment) {
        String query = "INSERT INTO payment (customer_id, staff_id, rental_id, amount, payment_date, last_update) "+
                        "VALUES (?, ?, ?, ?, now(), now());";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                
            pstmt.setInt(1, payment.getCustomerId());
            pstmt.setInt(2, payment.getStaffId());
            pstmt.setInt(3, payment.getRentalId());
            pstmt.setFloat(4, payment.getAmount());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Payment Added Successfully";
    }   
   
}

