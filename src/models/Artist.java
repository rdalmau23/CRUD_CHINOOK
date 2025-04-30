package models;

/**
 * Classe que representa un artista de la base de dades Chinook.
 */
public class Artist {
    private int id;
    private String name;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "ID: " + id + ", NOM: " + name;
    }
}
