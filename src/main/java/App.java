import jdk.jfr.events.ExceptionThrownEvent;
import model.Model;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.cert.Extension;
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

        Menu menu = new Menu();

        /*todo: wywołanie fukncji odpowiedzialnej za menu uzytkownika
                obiekt menu zawiera informacje o roku, imieniu, nazwisku i rodzaju raportu
                powyzsze atrybuty dostepne sa za pomoca getterow z obiektu menu
        */

        menu.mainMenuPanel();

        Reader reader = new Reader();
        Model model = new Model();

        reader.getExcels(new File(String.valueOf(menu.getPath())));

        List<File> listOfFiles = reader.getResult();

        Report report = null;
        switch (menu.getReportType()){
            case(1):
                report = new Report1(Integer.toString(menu.getYear()));
                break;

            case(2):
                report = new Report2(Integer.toString(menu.getYear()));
                break;

            case(3):
                report = new Report3(menu.getName(), menu.getSurnameName(), Integer.toString(menu.getYear()));
                break;

            case(4):
                report = new Report4(menu.getName(), menu.getSurnameName(), Integer.toString(menu.getYear()));
                break;
        }

        for(File singleXlsFile : listOfFiles){
            ExcelHandler excelHandler = new ExcelHandler(model);
            excelHandler.read(singleXlsFile );
            report.setDataModel(model);
        }
        report.generate();
        List<List<String>> outlist = report.getOutputList();

        Printer printer;
        printer = new ConsolePrint(outlist);
        try{
            printer.print();

        } catch (Exception e) {
            System.out.println("Wyjatek" + e);
        }


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
}
