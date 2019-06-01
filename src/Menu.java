import java.io.File;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    private File path;
    private String name;
    private int reportType;
    private int year;
    private String outputType;

    public Menu() {}

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int rok) {
        this.year = rok;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }


    public void mainMenu() {
        //String exit;

        System.out.println("Witaj w systemie generowania raportów");
        System.out.println();
        System.out.println("Podaj ścieżkę do danych wejściowych.");

        String pathString = scanner.next();
        this.path = new File(pathString);

        System.out.println("Wybierz rodzaj raportu:");
        System.out.println("1. Raport roczny wg. wszystkich pracowników");
        System.out.println("2. Raport roczny wg. projektów");
        System.out.println("3. Raport roczny pracownika");
        System.out.println("4. Raport roczny pracownika procentowy wg. projektu");
        System.out.println("5. Raport roczny top 10 zadań");

        this.reportType = scanner.nextInt();

        //System.out.println("Wpisz q aby zakonczyc");
        //exit = scanner.next();

        switch (reportType) {
            case 1:
                System.out.println("Podaj rok");
                this.year = Integer.parseInt(scanner.next());
                break;
            case 2:
                System.out.println("Raport niedostepny");
                //System.out.println("Podaj rok");
                //this.year = Integer.parseInt(scanner.next());

                //System.out.println("Wpisz q aby zakonczyc");
                //exit = scanner.next();
                break;
            case 3:
                System.out.println("Podaj imie pracownika");
                String firstName = scanner.next();

                System.out.println("Podaj nazwisko pracownika");
                String lastName = scanner.next();

                this.name = lastName+"_"+firstName;

                System.out.println("Podaj rok");
                this.year = scanner.nextInt();
                break;
            case 4:
                System.out.println("Raport niedostępny");

//                System.out.println("Podaj imie pracownika");
//                String firstName = scanner.next();
//
//                System.out.println("Podaj nazwisko pracownika");
//                String lastName = scanner.next();
//
//                this.name = lastName+"_"+firstName;
//
//                System.out.println("Podaj rok");
//                this.year = scanner.nextInt();

                break;
            case 5:
                System.out.println("Raport niedostępny");

                // jakies podawanie słow  kluczowych itp
                // trzeba tez uzupełnić pola klasy!

                break;
            default:
                System.out.println("Niema takiego rodzaju");
                break;
        }

        System.out.println("Podaj rodzaj wyjścia:");
        System.out.println("K - Konsola");
        System.out.println("E - Excel");
        System.out.println("P - Pdf");
        System.out.println("W - Excel z wykresem");

        this.outputType = scanner.next();


    }


}
