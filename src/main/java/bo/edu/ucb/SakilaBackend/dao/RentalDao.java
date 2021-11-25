package bo.edu.ucb.SakilaBackend.dao;

import bo.edu.ucb.SakilaBackend.dto.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class RentalDao {
    private DataSource dataSource;

    @Autowired
    public RentalDao (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String AddRental(Rental rental) {
        String query = "INSERT INTO rental (rental_date, inventory_id, customer_id, return_date, staff_id, last_update) "+
                        "VALUES (now(), ?, ?, ?, ?, now());";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {

            pstmt.setInt(1, rental.getInventoryId());
            pstmt.setInt(2, rental.getCustomerId());
            pstmt.setString(3, rental.getReturnDate());
            pstmt.setInt(4, rental.getStaffId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Rental Added Successfully";
    }   
   
}
