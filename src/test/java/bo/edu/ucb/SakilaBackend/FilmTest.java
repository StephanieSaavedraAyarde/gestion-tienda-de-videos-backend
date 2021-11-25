package bo.edu.ucb.SakilaBackend;

import bo.edu.ucb.SakilaBackend.bl.FilmBl;
import bo.edu.ucb.SakilaBackend.dto.Film;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class FilmTest{

	@Autowired
	FilmBl filmBl;

	@Test
	void findByCountry() {
		List<Film> films = filmBl.findByCountry(1);
		assertNotNull(films, "La busqueda retorno una lista nula");
		Film film = films.get(0);
		assertEquals("ACADEMY DINOSAUR", film.getTitle(), "El titulo de la película no coincide");
		assertTrue( film.getDescription().startsWith("A Epic Drama of a Feminist And a Mad Scientist"), "La descripcion de la película no coincide");
	}

	@Test
	void findByTitle() {
		List<Film> films = filmBl.findByTitle(1, "MAUDE");
		assertNotNull(films, "La busqueda retorno una lista nula");
		Film film = films.get(0);
		assertEquals("MAUDE MOD", film.getTitle(), "El titulo de la película no coincide");
		assertTrue( film.getDescription().startsWith("A Beautiful Documentary of a Forensic"), "La descripcion de la película no coincide");
	}

	@Test
	void Premiere() {
		List<Film> films = filmBl.Premiere(1);
		assertNotNull(films, "La busqueda retorno una lista nula");
		Film film = films.get(0);
		assertEquals("ZORRO ARK", film.getTitle(), "El titulo de la película no coincide");
		assertTrue( film.getDescription().startsWith("A Intrepid Panorama of a Mad Scientist"), "La descripcion de la película no coincide");
	}

	@Test
	void LastWeek() {
		List<Film> films = filmBl.LastWeek(1);
		assertNotNull(films, "La busqueda retorno una lista nula");
		Film film = films.get(0);
		assertEquals("ACADEMY DINOSAUR", film.getTitle(), "El titulo de la película no coincide");
		assertTrue( film.getDescription().startsWith("A Epic Drama of a Feminist And a Mad Scientist"), "La descripcion de la película no coincide");
	}

	@Test
	void AllTimes() {
		List<Film> films = filmBl.AllTimes(1);
		assertNotNull(films, "La busqueda retorno una lista nula");
		Film film = films.get(0);
		assertEquals("LOVE SUICIDES", film.getTitle(), "El titulo de la película no coincide");
		assertTrue( film.getDescription().startsWith("A Brilliant Panorama of a Hunter And a Explorer"), "La descripcion de la película no coincide");
	}
}

