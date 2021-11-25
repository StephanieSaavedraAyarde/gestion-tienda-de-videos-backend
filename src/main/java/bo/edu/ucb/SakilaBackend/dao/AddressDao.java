package bo.edu.ucb.SakilaBackend.dao;

import bo.edu.ucb.SakilaBackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class AddressDao {
    private DataSource dataSource;

    @Autowired
    public AddressDao (DataSource dataSource) {
        this.dataSource = dataSource;
    }
       
    public List<Address> FindById(Integer addressId) {
        List<Address> result = new ArrayList<>();
        String query =  " SELECT distinct a.address_id, a.address"+
                        " from address a, customer c"+
                        " WHERE a.address_id = c.address_id"+
                        " AND c.customer_id = ?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                
            pstmt.setInt(1, addressId);
            ResultSet rs = pstmt.executeQuery();
                
            while(rs.next()) {
                Address address = new Address();
    
                address.setAddressId(rs.getInt("address_id"));
                address.setAddress(rs.getString("address"));
                result.add(address);
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return result;
    }
   
    public String UpdateCustomerAddress(Integer customerId, String address) {
        String query =  " UPDATE address"+
                        " INNER JOIN customer ON customer.address_id=address.address_id" +
                        " SET address.address= ?, address.last_update=now()" +
                        " WHERE customer.customer_id = ?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                
            pstmt.setString(1, address);
            pstmt.setInt(2, customerId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Customer Address Updated Successfully";
    }
}
