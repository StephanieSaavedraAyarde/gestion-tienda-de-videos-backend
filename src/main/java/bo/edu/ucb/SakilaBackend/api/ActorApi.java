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
public class ActorApi {

    ActorBl actorBl;

    @Autowired
    public ActorApi(ActorBl actorBl) {
        this.actorBl = actorBl;
    }

    @GetMapping(value = "/actor/{country}/{firstname}/{lastname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Actor> findByActor(@PathVariable(name = "firstname") String firstname, @PathVariable(name = "lastname") String lastname, @PathVariable(name = "country") Integer country){
        return actorBl.findByActor(country, firstname, lastname);
    }
}
