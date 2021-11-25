package bo.edu.ucb.SakilaBackend.dto;

import java.util.Objects;

public class Film {
    private Integer filmId;
    private String title;
    private String description;

    public Film() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmId.equals(film.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId);
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Description: " + description + "\n";
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

