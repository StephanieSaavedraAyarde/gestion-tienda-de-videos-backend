package bo.edu.ucb.SakilaBackend.api;

import bo.edu.ucb.SakilaBackend.bl.*;
import bo.edu.ucb.SakilaBackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController()
public class FilmApi {

    FilmBl filmBl;
    ActorBl actorBl;

    @Autowired
    public FilmApi(FilmBl filmBl) {
        this.filmBl = filmBl;
    }

    @GetMapping(value = "/film/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findBytTitle(@PathVariable(name = "country") Integer country){
        return filmBl.findByCountry(country);
    }

    @GetMapping(value = "/film/{country}/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findByTitle(@PathVariable(name = "title") String title, @PathVariable(name = "country") Integer country){
        return filmBl.findByTitle(country, title);
    }

    @GetMapping(value = "/premiere/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> Premiere(@PathVariable(name = "country") Integer country){
        return filmBl.Premiere(country);
    }

    @GetMapping(value = "/lastweek/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> LastWeek(@PathVariable(name = "country") Integer country){
        return filmBl.LastWeek(country);
    }

    @GetMapping(value = "/alltimes/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> AllTimes(@PathVariable(name = "country") Integer country){
        return filmBl.AllTimes(country);
    }
}