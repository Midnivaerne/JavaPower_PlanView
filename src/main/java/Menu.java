import java.io.File;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    private File path;
    private String name;
    private String surnameName;
    private int reportType;
    private int year;
    private String outputType;

    public Menu() {
    }

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

    String check;

    public void displayReturnToMainMenuPanel() {
        System.out.println("*** Chcesz wrócić do Menu głównego? Kliknij \"m\" ***");
    }

    public void mainMenuPanel() {

        System.out.println("-------Witaj w systemie generowania raportów-------");
        System.out.println();
        System.out.println("(A) Podaj ścieżkę do danych wejściowych. path = ");
        System.out.println("*** Jeśli chcesz wyjśc z aplikacji wpisz \"q\" ***");

        check = scanner.nextLine();

        if (check.equals("q")) {
            System.exit(0);
        }

        String pathString = check;
        this.path = new File(pathString);

        if (this.path.exists()) {
            reportTypePanel();
        } else {
            System.out.println("!!! Ścieżka nie istnieje, wpisz jeszcze raz. !!!");
            mainMenuPanel();
        }

    }

    public void reportTypePanel() {

        System.out.println("----------------------------------------------------");
        System.out.println("(B) Wybierz rodzaj raportu:");
        System.out.println("1. Raport roczny wg. wszystkich pracowników");
        System.out.println("2. Raport roczny wg. projektów");
        System.out.println("3. Raport roczny pracownika");
        System.out.println("4. Raport roczny pracownika procentowy wg. projektu");
        System.out.println("5. Raport roczny top 10 zadań");

        displayReturnToMainMenuPanel();

        String check;
        check = scanner.nextLine();

        if (check.equals("m")) {
            mainMenuPanel();
        }

        if (check.equals("1") || check.equals("2") || check.equals("3") || check.equals("4") || check.equals("5")) {
            this.reportType = Integer.parseInt(check);
            dataPanel(this.reportType);
        } else {
            System.out.println("!!! Nie ma takiego raportu spróbuj jeszcze raz !!!");
            reportTypePanel();
        }
    }

    public void dataPanel(int type) {

        System.out.println("----------------------------------------------------");
        System.out.println("(C) Podaj dane potrzebne do raportu:");

        displayReturnToMainMenuPanel();

        switch (type) {
            case 1:
                System.out.println("Podaj rok: ");

                try {
                    this.year = Integer.parseInt(scanner.nextLine());
                    outputTypePanel();
                } catch (Exception error) {
                    System.out.println("!!! Podany rok ma zły format !!!");
                    dataPanel(type);
                }
                break;
            case 2:
                System.out.println("!!! Raport niedostepny, wybierz inny !!!");
                reportTypePanel();

                //System.out.println("Podaj rok");
                //this.year = Integer.parseInt(scanner.next());

                break;
            case 3:
                System.out.println("Podaj imie pracownika: ");
                String firstName = scanner.nextLine();

                System.out.println("Podaj nazwisko pracownika ");
                String lastName = scanner.nextLine();

                this.name = firstName;
                this.surnameName = lastName;

                System.out.println("Podaj rok: ");

                try {
                    this.year = Integer.parseInt(scanner.nextLine());
                    outputTypePanel();
                } catch (Exception error) {
                    System.out.println("!!! Podany rok ma zły format !!!");
                    dataPanel(type);
                }

                break;
            case 4:
                System.out.println("!!! Raport niedostępny, wybierz inny !!!");
                reportTypePanel();

//              System.out.println("Podaj imie pracownika");
//              String firstName = scanner.next();
//
//              System.out.println("Podaj nazwisko pracownika");
//              String lastName = scanner.next();
//
//              this.name = lastName+"_"+firstName;
//
//              System.out.println("Podaj rok");
//              this.year = scanner.nextInt();

                break;
            case 5:
                System.out.println("!!! Raport niedostępny, wybierz inny !!!");
                reportTypePanel();

                // jakies podawanie słow  kluczowych itp
                // trzeba tez uzupełnić pola klasy!

                break;
            default:
                break;

        }
    }

    public void outputTypePanel() {

        System.out.println("----------------------------------------------------");
        System.out.println("(D) Podaj rodzaj wyjścia:");
        System.out.println("K - Konsola");
        System.out.println("E - Excel");
        System.out.println("P - Pdf");
        System.out.println("W - Excel z wykresem");

        displayReturnToMainMenuPanel();

        this.outputType = scanner.nextLine();

        switch (this.outputType) {
            case "K":
                System.out.println("Dane przyjęte, raport zostanie wygenerowany");
                break;
            case "E":
                System.out.println("Dane przyjęte, raport zostanie wygenerowany");
                break;
            case "P":
                System.out.println("!!! Wybacz, funkcja niedostepna, spróbuj jeszcze raz !!!");
                outputTypePanel();
                break;
            case "W":
                System.out.println("!!! Wybacz, funkcja niedostepna, spróbuj jeszcze raz !!!");
                outputTypePanel();
                break;
            case "m":
                mainMenuPanel();
                break;
            default:
                System.out.println("!!! Nie ma takiego rodzaju, spróbuj jeszcze raz !!!");
                outputTypePanel();
                break;
        }


    }


    public String getSurnameName() {
        return surnameName;
    }

    public void setSurnameName(String surnameName) {
        this.surnameName = surnameName;
    }
}

