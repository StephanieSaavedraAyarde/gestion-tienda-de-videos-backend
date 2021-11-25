package bo.edu.ucb.SakilaBackend.dao;

import bo.edu.ucb.SakilaBackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilmDao {
    private DataSource dataSource;

    @Autowired
    public FilmDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Film> findByCountry(Integer country) {
        List<Film> result = new ArrayList<>();
        String query = " SELECT DISTINCT f.film_id, f.title, f.description" +
                       " FROM film f" +
                       " LEFT JOIN inventory i ON (i.film_id = f.film_id)" +
                       " LEFT JOIN store s ON (s.store_id =i.store_id)" +
                       " LEFT JOIN address a ON (a.address_id = s.address_id)" +
                       " LEFT JOIN city ci ON (ci.city_id = a.city_id)" +
                       " LEFT JOIN country co ON (co.country_id = ci.country_id)" +
                       " WHERE"+
                       " (s.store_id) LIKE (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                
            pstmt.setInt(1, country);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Film film = new Film();

                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                result.add(film);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }   
   
    public List<Film> findByTitle(Integer country, String title) {
        List<Film> result = new ArrayList<>();
        String query = " SELECT DISTINCT f.film_id, f.title, f.description, f.release_year" +
                       " FROM film f" +
                       " LEFT JOIN inventory i ON (i.film_id = f.film_id)" +
                       " LEFT JOIN store s ON (s.store_id =i.store_id)" +
                       " LEFT JOIN address a ON (a.address_id = s.address_id)" +
                       " LEFT JOIN city ci ON (ci.city_id = a.city_id)" +
                       " LEFT JOIN country co ON (co.country_id = ci.country_id)" +
                       " WHERE"+
                       "    (s.store_id) LIKE (?)" +
                       "    AND UPPER(title) LIKE (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
            
            pstmt.setInt(1, country);
            pstmt.setString(2, "%"+title.toUpperCase()+ "%");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Film film = new Film();

                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                result.add(film);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Film> Premiere(Integer country) {
        List<Film> result = new ArrayList<>();
        String query =  " SELECT DISTINCT f.film_id,f.title, f.description,cc.country" +
                        " FROM film f" +
                        " LEFT JOIN inventory i on (i.film_id=f.film_id)" +
                        " LEFT JOIN rental r on (r.inventory_id=i.inventory_id)" +
                        " LEFT JOIN store s on (s.store_id=i.store_id)" +
                        " LEFT JOIN address a on (a.address_id=s.address_id)" +
                        " LEFT JOIN city cy on (cy.city_id=a.city_id)" +
                        " LEFT JOIN country cc on(cc.country_id=cy.country_id)" +
                        " LEFT JOIN film_category fc on (fc.film_id=f.film_id)" +
                        " LEFT JOIN category c on(c.category_id=fc.category_id)" +
                        " WHERE s.store_id = (?)" +
                        " ORDER BY film_id DESC LIMIT 10";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
            
            pstmt.setInt(1, country);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Film film = new Film();

                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                result.add(film);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Film> LastWeek(Integer country) {
        List<Film> result = new ArrayList<>();
        String query =  " SELECT  f.film_id, f.title, f.description,co.country, COUNT(f.title) as TIMES" +
                        " FROM film f" +
                        " LEFT JOIN inventory i ON (i.film_id = f.film_id)" +
                        " LEFT JOIN rental r on (r.inventory_id = i.inventory_id)" +
                        " LEFT JOIN store s ON (s.store_id =i.store_id)" +
                        " LEFT JOIN address a ON (a.address_id = s.address_id)" +
                        " LEFT JOIN city ci ON (ci.city_id = a.city_id)" +
                        " LEFT JOIN country co ON (co.country_id = ci.country_id)" +
                        " WHERE r.rental_date > DATE_SUB('2006-02-15 21:30:53', INTERVAL 1 WEEK)" +
                        " AND (s.store_id) LIKE (?)" +
                        " GROUP BY f.title" +
                        " ORDER BY TIMES DESC LIMIT 10";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
            
            pstmt.setInt(1, country);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Film film = new Film();

                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                result.add(film);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Film> AllTimes(Integer country) {
        List<Film> result = new ArrayList<>();
        String query =  " SELECT  f.film_id, f.title, f.description, co.country, COUNT(f.title) as TIMES " +
                        " FROM film f" +
                        " LEFT JOIN inventory i ON (i.film_id = f.film_id)" +
                        " LEFT JOIN rental r on (r.inventory_id = i.inventory_id)" +
                        " LEFT JOIN store s ON (s.store_id =i.store_id)" +
                        " LEFT JOIN address a ON (a.address_id = s.address_id)" +
                        " LEFT JOIN city ci ON (ci.city_id = a.city_id)" +
                        " LEFT JOIN country co ON (co.country_id = ci.country_id)" +
                        " LEFT JOIN film_category fc on (fc.film_id=f.film_id)" +
                        " LEFT JOIN category c on(c.category_id=fc.category_id)" +
                        " WHERE (s.store_id) LIKE (?)" +
                        " GROUP BY f.title" +
                        " ORDER BY TIMES DESC LIMIT 10";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
            
            pstmt.setInt(1, country);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Film film = new Film();

                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                result.add(film);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
