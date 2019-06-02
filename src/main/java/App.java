import model.Model;

import java.nio.file.Path;
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
//        Reader reader = new Reader();
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
        Report1 r1 = new Report1("2000");
        Model m = new Model();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Project pr1 = new Project();
        //Task t1 = new Task();
        //Task t2 = new Task();


        ArrayList<Person> plist = new ArrayList<Person>();
        ArrayList<Project> prlist = new ArrayList<Project>();
        ArrayList<Task> tlist = new ArrayList<Task>();

        p1.setName("Adaś");
        p1.setSurname("Miałczyński");
        p2.setName("Jerzy");
        p2.setSurname("Zwierz");
        p3.setName("Jeż");
        p3.setSurname("Jerzy");
        t1.setHoursCount(20);
        t2.setHoursCount(100);
        tlist.add(t1);
        tlist.add(t2);
        pr1.setTaskList(tlist);
        prlist.add(pr1);
        p1.setProjectList(prlist);
        p2.setProjectList(prlist);
        p3.setProjectList(prlist);
        plist.add(p2);
        plist.add(p1);
        plist.add(p3);
        m.setPersonList(plist);


        r1.setDataModel(m);

        r1.generate();

        List<List<String>> outlist = r1.getOutputList();

        Printer printer;
        printer = new ConsolePrint(outlist);
        printer.print();
    }
    
    public static void TestModel(){
    	Task task1 = new Task("testowy", 10);
    	Task task2 = new Task("testowy2", 20);
    	
    	Task task3 = new Task("testowy3",30);
    	Task task4 = new Task("testowy4", 40);
    	
    	Project projectTest1 = new Project("ProjektA");
    	Project projektTest2 = new Project("ProjektB");
    	//dodanie zada� do projektu
    	
    	
    	projectTest1.addTaskToProjectList(task1);
    	projectTest1.addTaskToProjectList(task2);
    	
    	projektTest2.addTaskToProjectList(task3);
    	projektTest2.addTaskToProjectList(task4);
    	
    	
    	
    }




}
