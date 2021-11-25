package bo.edu.ucb.SakilaBackend.dao;

import bo.edu.ucb.SakilaBackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDao {
    private DataSource dataSource;

    @Autowired
    public CustomerDao (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String AddCustomer(Customer customer) {
        String query = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date, last_update) "+
                        "VALUES (?, ?, ?, ?, ?, ?, now(), now());";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                
            pstmt.setInt(1, customer.getStoreId());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getEmail());
            pstmt.setInt(5, customer.getAddress());
            pstmt.setInt(6, customer.getActive());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Customer Added Successfully";
    } 
    
    public String UpdateCustomerAddress(Integer customerId, Address address) {
        String query =  " UPDATE address"+
                        " INNER JOIN customer ON customer.address_id=address.address_id" +
                        " SET address.address= ?, address.last_update=now()" +
                        " WHERE customer.customer_id = ?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                
            pstmt.setString(1, address.getAddress());
            pstmt.setInt(2, customerId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Customer Address Updated Successfully";
    }
   

    public List<Customer> FindById(Integer customerId) {
        List<Customer> result = new ArrayList<>();
        String query =  " Select * FROM customer" +
                        " WHERE customer.address_id = ?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
                
            while(rs.next()) {
                Customer customer = new Customer();
    
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setStoreId(rs.getInt("store_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getInt("address_id"));
                customer.setActive(rs.getInt("active"));
                result.add(customer);
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return result;
    }
   
}
