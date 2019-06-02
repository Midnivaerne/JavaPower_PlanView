import model.Model;

import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import model.Person;
import model.Project;
import model.Model;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Path> xlsFilePaths;
        List<List<String>> rawData; //surowe dane do tworzenia raportów
        Model model = new Model();
        Reader reader = Reader.getInstance();
        Menu menu = new Menu();

        report1Test();

        /*todo: wywołanie fukncji odpowiedzialnej za menu uzytkownika
                obiekt menu zawiera informacje o roku, imieniu, nazwisku i rodzaju raportu
                powyzsze atrybuty dostepne sa za pomoca getterow z obiektu menu
        */

        menu.mainMenuPanel();


        /*todo: file scanner zbiera i zapisuje do listy sciezki do plikow xls -> zapisuje je do xlsFilePath
         */

        //todo: for each dla xlsFilePath, w kazdej petli wywolujemy Reader (który za posrednictwem excellHandlera odczyta plik)
        //      Reader przyjmuje jako argumenty sciezke do pliku xls, oraz utworzony model
        //      Po wczytaniu i przetworzeniu danych z excellHandlera dodaje je do otrzymanego modelu,
        //      Na koncu zwracany jest model z wstrzykniętymi nowymi danymi

        //todo: tworzymy obiekt raport (switch case na bazie menu.getRaport()), jako konstruktor raportu podajemy model
        //      Raport zwraca Listę list List<List<String>> generatedTable

        //todo: Wywolanie obiektu metody print(generatedTable) z obiektu Printer,
        //
    }

    public static void report1Test() {
        Report3 r1 = new Report3("Adaś", "Miałczyński","2000");
        Model m = new Model();
        Person p1 = new Person("Jerzy","Zwierz");
        Person p2 = new Person("Adaś", "Miałczyński");
        Project pr1 = new Project("NewProject");
        Task t1 = new Task(Date.valueOf(LocalDate.now()),"NewTask1",20);
        Task t2 = new Task(Date.valueOf(LocalDate.now()),"NewTask2",100);


        ArrayList<Person> plist = new ArrayList<Person>();
        ArrayList<Project> prlist = new ArrayList<Project>();
        ArrayList<Task> tlist = new ArrayList<Task>();


        tlist.add(t1);
        tlist.add(t2);
        pr1.setTaskList(tlist);
        prlist.add(pr1);
        p1.setProjectList(prlist);
        p2.setProjectList(prlist);
        plist.add(p1);
        plist.add(p2);
        m.setPersonList(plist);


        r1.setDataModel(m);

        r1.generate();


//        List<List<String>> outlist = r1.getOutputList();
//        System.out.println(r1.getReportHeader());
//        System.out.println(r1.getColumnHeader());
//        System.out.println(outlist.get(0).get(0) + " - " + outlist.get(1).get(0));
//        System.out.println(outlist.get(0).get(1) + " - " + outlist.get(1).get(1));

    }




}
