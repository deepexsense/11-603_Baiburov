package ru.itis.inform.models;

//Модель жанр-фильм
public class GenreFilm {
    private int filmId;
    private int genreId;

    public GenreFilm(int filmId, int genreId) {
        this.filmId = filmId;
        this.genreId = genreId;
    }

    public int getFilmId() {
        return filmId;
    }

    public int getGenreId() {
        return genreId;
    }
}
