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
        String query =  " Select * FROM address" +
                        " WHERE address.address_id = ?";

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
                address.setAddress2(rs.getString("address2"));
                address.setDistrict(rs.getString("district"));
                address.setCity_id(rs.getInt("city_id"));
                address.setPostal_code(rs.getString("postal_code"));
                address.setPhone(rs.getString("phone"));
                result.add(address);
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return result;
    }
   
}
