package bo.edu.ucb.SakilaBackend;

import bo.edu.ucb.SakilaBackend.bl.*;
import bo.edu.ucb.SakilaBackend.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class ActorTest {

	@Autowired
	ActorBl actorBl;

	@Test
	void findExactlyOne() {
		List<Actor> actors = actorBl.findByActor(1, "Ed", "Chase");
		assertNotNull(actors, "La busqueda retorno una lista nula");
		Actor actor = actors.get(0);
		assertEquals("ED", actor.getFirst_name(), "No se encontro un actor con ese nombre");
        assertEquals("CHASE", actor.getLast_name(), "No se encontro un actor con ese apellido");
        assertEquals("ACADEMY DINOSAUR", actor.getTitle(), "El titulo de la pelicula no coincide");
        assertTrue( actor.getDescription().startsWith("A Epic Drama of a Feminist And a Mad Scientist"), "La descripcion de la película no coincide");
	}

}