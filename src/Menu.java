import java.io.File;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    private File path;
    private String imieNazwisko;
    private int rodzajRaportu;
    private int rok;
    private String rodzajWyjscia;

    public Menu() {}

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public String getImieNazwisko() {
        return imieNazwisko;
    }

    public void setImieNazwisko(String imieNazwisko) {
        this.imieNazwisko = imieNazwisko;
    }

    public int getRodzajRaportu() {
        return rodzajRaportu;
    }

    public void setRodzajRaportu(int rodzajRaportu) {
        this.rodzajRaportu = rodzajRaportu;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public String getRodzajWyjscia() {
        return rodzajWyjscia;
    }

    public void setRodzajWyjscia(String rodzajWyjscia) {
        this.rodzajWyjscia = rodzajWyjscia;
    }

    public static void main(String[] args) {
    }

    public void menuGlowne() {
        System.out.println("Witaj w systemie generowania raportów");
        System.out.println("Podaj ścieżkę do danych wejściowych.");

        String path = "";

        String pathString = scanner.next();
        this.path = new File(pathString);
    }

    public static void menuRaport() {
        System.out.println("Wybierz rodzaj raportu:");
        System.out.println("1. Raport roczny wg. wszystkich pracowników");
        System.out.println("2. Raport roczny wg. projektów");
        System.out.println("3. Raport roczny pracownika");
        System.out.println("4. Raport roczny pracownika procentowy wg. projektu");
        System.out.println("5. Raport roczny top 10 zadań");
        System.out.println("Wpisz m aby wrócić do menu głównego");
        System.out.println("Wpisz q aby zakonczyc");

        String wybor = scanner.next();
        if(wybor.equalsIgnoreCase("m")) {
            menuGlowne();
        } else if (wybor.equalsIgnoreCase("q")) {
            // wyjdz z programu
        } else {
            int rodzajRaportu = Integer.parseInt(wybor);
        }
    }

    public void menuDane(int rodzajRaportu) {
        int rok;
        String imiePracownika;
        String wybor;
        switch (rodzajRaportu) {
            case 1:
                System.out.println("Podaj rok");
                wybor = scanner.next();
                rok = Integer.parseInt(wybor);

                break;
            case 2:
                System.out.println("Raport niedostepny");
                // wpisz q aby wrocic do menu glownego
                break;
            case 3:
                System.out.println("Podaj imie i nazwisko pracownika");
                imiePracownika = scanner.next();

                System.out.println("Podaj rok");
                rok = scanner.nextInt();
                break;
            case 4:
                System.out.println("Raport niedostępny");
//                System.out.println("Podaj imie i nazwisko pracownika");
//                imiePracownika = scanner.next();
//
//                System.out.println("Podaj rok");
                break;
            case 5:
                System.out.println("Raport niedostępny");
                break;
            default:
        }
    }

    public static void menuWyjscie() {

    }

}
