package bo.edu.ucb.SakilaBackend.bl;

import bo.edu.ucb.SakilaBackend.dao.ActorDao;
import bo.edu.ucb.SakilaBackend.dto.Actor;
import bo.edu.ucb.SakilaBackend.exception.SakilaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorBl {

    private final ActorDao actorDao;

    @Autowired
    public ActorBl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    public List<Actor> findByActor(Integer country, String firstname, String lastname) {
        if (country == null || firstname == null || firstname.trim().equals("") 
            || lastname == null || lastname.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The firstname, lastname and country parameter are mandatory and can't be null or empty");
        }
        return actorDao.findByActor(country, firstname, lastname);
    }
}
