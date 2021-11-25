package bo.edu.ucb.SakilaBackend.bl;

import bo.edu.ucb.SakilaBackend.dao.FilmDao;
import bo.edu.ucb.SakilaBackend.dto.Film;
import bo.edu.ucb.SakilaBackend.exception.SakilaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmBl {

    private final FilmDao filmDao;

    @Autowired
    public FilmBl(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    public List<Film> findByCountry(Integer country) {
        if (country == null) {
            throw new SakilaException(403, "Bad request: The country parameter is mandatory and can't be null or empty");
        }
        return filmDao.findByCountry(country);
    }

    public List<Film> findByTitle(Integer country, String title) {
        if (country == null || title == null || title.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The title and country parameter are mandatory and can't be null or empty");
        }
        return filmDao.findByTitle(country, title);
    }

    public List<Film> Premiere(Integer country) {
        if (country == null) {
            throw new SakilaException(403, "Bad request: The country parameter is mandatory and can't be null or empty");
        }
        return filmDao.Premiere(country);
    }

    public List<Film> LastWeek(Integer country) {
        if (country == null) {
            throw new SakilaException(403, "Bad request: The country parameter is mandatory and can't be null or empty");
        }
        return filmDao.LastWeek(country);
    }

    public List<Film> AllTimes(Integer country) {
        if (country == null) {
            throw new SakilaException(403, "Bad request: The country parameter is mandatory and can't be null or empty");
        }
        return filmDao.AllTimes(country);
    }
}

