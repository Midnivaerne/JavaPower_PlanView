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

    //String exit;

    String check;

    public void mainMenuPanel() {

        System.out.println("Witaj w systemie generowania raportów");
        System.out.println();
        System.out.println("Podaj ścieżkę do danych wejściowych.");

        String pathString = scanner.next();
        this.path = new File(pathString);

        // sprawdź czy ścieżka istnieje jak nie to daj wyjątek


        reportTypePanel();


        //System.out.println("Wpisz q aby zakonczyc");
        //exit = scanner.next();
    }

    public void reportTypePanel() {

        System.out.println("Wybierz rodzaj raportu:");
        System.out.println("1. Raport roczny wg. wszystkich pracowników");
        System.out.println("2. Raport roczny wg. projektów");
        System.out.println("3. Raport roczny pracownika");
        System.out.println("4. Raport roczny pracownika procentowy wg. projektu");
        System.out.println("5. Raport roczny top 10 zadań");
        System.out.println("***chcesz wrócić do Menu głównego? Kliknij m");

        String check;
        check = scanner.next();

        if (check.equals("m")) {
            mainMenuPanel();
        }
        else{
            this.reportType = Integer.parseInt(check);
        }

        if (this.reportType == 1 || this.reportType == 2 || this.reportType == 3 || this.reportType == 4 || this.reportType == 5 ) {
            dataPanel(this.reportType);
        }
        else {
            System.out.println("Nie ma takiego raportu spróbuj jeszcze raz");
            reportTypePanel();
        }



        //System.out.println("Wpisz q aby zakonczyc");
        //exit = scanner.next();

    }
    public void dataPanel(int type) {

        switch (type) {
            case 1:
                    System.out.println("Podaj rok");
                    this.year = Integer.parseInt(scanner.next());
                    break;

                    case 2:
                        System.out.println("Raport niedostepny, wybierz inny");
                    reportTypePanel();
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

                    this.name = lastName + "_" + firstName;

                    System.out.println("Podaj rok");
                    this.year = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Raport niedostępny, wybierz inny");
                    reportTypePanel();

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
                    System.out.println("Raport niedostępny, wybierz inny");
                    reportTypePanel();

                    // jakies podawanie słow  kluczowych itp
                    // trzeba tez uzupełnić pola klasy!

                    break;
                default:
                    break;

        }

            System.out.println("***czy iść dalej? Kliknij d");
            System.out.println("***chcesz wrócić do Menu głównego? Kliknij m");

            check = scanner.next();

            if (check.equals("d")) {
                outputTypePanel();
            }
            if (check.equals("m")) {
                mainMenuPanel();
            }
    }

    public void outputTypePanel() {

            System.out.println("Podaj rodzaj wyjścia:");
            System.out.println("K - Konsola");
            System.out.println("E - Excel");
            System.out.println("P - Pdf");
            System.out.println("W - Excel z wykresem");
            System.out.println("Chcesz wrócić do menu głównego kliknij m");

            this.outputType = scanner.next();

            switch(this.outputType){
                case "K":
                    System.out.println("Dane przyjęte, raport zostanie wygenerowany");
                    break;
                case "E":
                    System.out.println("Dane przyjęte, raport zostanie wygenerowany");
                    break;
                case "P":
                    System.out.println("Wybacz funkcja niedostepna, spróbuj jeszcze raz");
                    outputTypePanel();
                    break;
                case"W":
                    System.out.println("Wybacz funkcja niedostepna, spróbuj jeszcze raz");
                    outputTypePanel();
                    break;
                case"m":
                    mainMenuPanel();
                    break;
                default:
                    System.out.println("Nie ma takiego rodzaju, spróbuj jeszcze raz");
                    outputTypePanel();
                    break;
            }


    }


}

