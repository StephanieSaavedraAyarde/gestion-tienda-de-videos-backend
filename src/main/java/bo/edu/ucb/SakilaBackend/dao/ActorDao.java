package bo.edu.ucb.SakilaBackend.dao;

import bo.edu.ucb.SakilaBackend.dto.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ActorDao {
    private DataSource dataSource;

    @Autowired
    public ActorDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Actor> findByActor(Integer country, String firstname, String lastname) {
        List<Actor> result = new ArrayList<>();
        String query = " SELECT DISTINCT ac.actor_id, ac.first_name, ac.last_name, f.film_id, f.title, f.description" +
                       " FROM actor ac, film f" +
                       " LEFT JOIN inventory i ON (i.film_id = f.film_id)" +
                       " LEFT JOIN store s ON (s.store_id =i.store_id)" +
                       " LEFT JOIN address a ON (a.address_id = s.address_id)" +
                       " LEFT JOIN city ci ON (ci.city_id = a.city_id)" +
                       " LEFT JOIN country co ON (co.country_id = ci.country_id)" +
                       " WHERE"+
                       "    (s.store_id) LIKE (?)" +
                       "    AND UPPER( ac.first_name) LIKE (?)" +
                       "    AND UPPER( ac.last_name) LIKE (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                
            pstmt.setInt(1, country);
            pstmt.setString(2, "%"+firstname.toUpperCase()+ "%");
            pstmt.setString(3, "%"+lastname.toUpperCase()+ "%");
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Actor actor = new Actor();
                actor.setActorId(rs.getInt("actor_id"));
                actor.setFirst_name(rs.getString("first_name"));
                actor.setLast_name(rs.getString("last_name"));
                actor.setFilmId(rs.getInt("film_id"));
                actor.setTitle(rs.getString("title"));
                actor.setDescription(rs.getString("description"));
                result.add(actor);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }   

}

