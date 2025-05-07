import service.ArtistService;

import java.util.Scanner;

/**
 * Classe principal amb el menú que executa el programa per gestionar la base de dades Chinook.
 * @author Rafel Dalmau
 * @date 07-05-2025
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArtistService artistService = new ArtistService();

        int opcio;
        do {
            System.out.println("Menú principal");
            System.out.println("1 - Consultar tots els artistes");
            System.out.println("2 - Consultar artistes pel seu nom");
            System.out.println("3 - Consultar 5 primers àlbums d’un artista");
            System.out.println("4 - Afegir un artista");
            System.out.println("5- Modificar un artista");
            System.out.println("6 - Esborrar un artista");
            System.out.println("7 - Sortir");
            System.out.print("Selecciona una opció: ");

            opcio = Integer.parseInt(scanner.nextLine());

            switch (opcio) {
                case 1 -> artistService.obtenirTotsArtistes();
                case 2 -> artistService.buscarArtista(scanner);
                case 3 -> artistService.obtenirCincAlbums(scanner);
                case 4 -> artistService.afegirArtista(scanner);
                case 5 -> artistService.modificarArtista(scanner);
                case 6 -> artistService.eliminarArtista(scanner);
                case 0 -> System.out.println("Sortint...");
                default -> System.out.println("Opció no vàlida");
            }

        } while (opcio != 0);

        scanner.close();
    }
}
