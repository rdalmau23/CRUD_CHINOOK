package service;

import db.DatabaseConnection;
import models.Artist;

import java.sql.*;
import java.util.Scanner;

/**
 * Classe que gestiona les operacions CRUD relacionades amb la taula artist.
 */
public class ArtistService {

    /**
     * Mostra tots els artistes de la base de dades
     */
    public void obtenirTotsArtistes() {
        String sql = "SELECT * FROM artist";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean found = false;
            while (rs.next()) {
                Artist artist = new Artist(rs.getInt("artist_id"), rs.getString("name"));
                System.out.println(artist);
                found = true;
            }
            if (!found) System.out.println("No hi ha resultats per aquesta consulta.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cerca artistes pel nom
     */
    public void buscarArtista(Scanner scanner) {
        System.out.print("Introdueix el nom de l'artista: ");
        String name = scanner.nextLine();

        if (name.length() < 2) {
            System.out.println("Has d'introduir almenys 2 caràcters");
            return;
        }

        String sql = "SELECT * FROM artist WHERE name ILIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                System.out.println(new Artist(rs.getInt("artist_id"), rs.getString("name")));
                found = true;
            }
            if (!found) System.out.println("No hi ha resultats per aquesta consulta.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra els 5 primers albums d’un artista pel seu nom.
     */
    public void obtenirCincAlbums(Scanner scanner) {
        System.out.print("Introdueix el nom de l'artista: ");
        String name = scanner.nextLine();

        if (name.length() < 2) {
            System.out.println("Has d'introduir almenys 2 caràcters");
            return;
        }

        String sql = """
            SELECT album.album_id, album.title, artist.name AS artist_name
            FROM album
            JOIN artist ON album.artist_id = artist.artist_id
            WHERE artist.name ILIKE ?
            ORDER BY album.album_id
            LIMIT 5
            """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name + "%");
            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                System.out.println("ID_ALBUM: " + rs.getInt("album_id") +
                                   ", NOM_ALBUM: " + rs.getString("title") +
                                   ", NOM_ARTISTA: " + rs.getString("artist_name"));
                found = true;
            }
            if (!found) System.out.println("No hi ha resultats per aquesta consulta.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Afegeix un nou artista.
     */
    public void afegirArtista(Scanner scanner) {
        System.out.print("Introdueix el nom de l'artista a afegir: ");
        String name = scanner.nextLine();

        if (name.length() < 2) {
            System.out.println("Has d'introduir almenys 2 caràcters");
            return;
        }

        String sql = "INSERT INTO artist (name) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.executeUpdate();
            System.out.println("L’artista s’ha afegit correctament");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Modifica el nom d’un artista segons la seva ID.
     */
    public void modificarArtista(Scanner scanner) {
        System.out.print("Introdueix la ID de l'artista a modificar: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Introdueix el nou nom: ");
        String name = scanner.nextLine();

        if (name.length() < 2) {
            System.out.println("Has d'introduir almenys 2 caràcters");
            return;
        }

        String sql = "UPDATE artist SET name = ? WHERE artist_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("L’artista s’ha modificat correctament");
            else System.out.println("No s’ha trobat cap artista amb aquesta ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Esborra un artista segons la seva ID.
     */
    public void eliminarArtista(Scanner scanner) {
        System.out.print("Introdueix la ID de l'artista a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        String sql = "DELETE FROM artist WHERE artist_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("L’artista s’ha esborrat correctament");
            else System.out.println("No s’ha trobat cap artista amb aquesta ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
