import model.Model;
import model.Person;
import model.Project;
import model.Task;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ExcelHandler {

    //fields
    //referencja do modelu
    Model model;

    public ExcelHandler(Model model) {
        this.model = model;
    }

//    public void AddDataTotModel() {
//
//    }

    //in: parsowanie pojedynczego excella
    //path to file (nazwa pliku podana przez FSParser)
    public void read(File file) {

        int personNumber = 0;
        int projectNumber = 0;
        int taskNumber = 0;

        //Otwarcie pliku MS Excel
        Workbook wb = null;
        try {
            // ******************** Person ******************
            // wez z nazwy pliku
            String stringFileName = file.getName();//"Kowalski_Jan.xls";
            String[] nameSurname = stringFileName.split("_");
            //Kowalski          Jan.xls
            String surname = nameSurname[0];
            String[] nameExtension = nameSurname[1].split("\\.");
            //Jan               xls
            String name = nameExtension[0];
            //System.out.println("name: " + name + ", surname: " + surname);

            Person person = new Person(name, surname);

            //check if istnieje w modelu
            //model.getPersonList
            personNumber = model.getPersonList().indexOf(person);
            if (personNumber != -1) {
                System.out.println("Person found");
            } else {
                System.out.println("Person not found");
                //if nie istnieje > dodac; list.add()
                model.getPersonList().add(person);
                personNumber = model.getPersonList().indexOf(person);
            }

            // plik powinien znajdowac sie w glownym katalogu projektu
            wb = WorkbookFactory.create(file);//"workbook.xlsx"; file.getName()
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        }

        int sheetIndex = 0;
        //pobierz liczbe arkuszy w pliku
        int nSheetNumber = wb.getNumberOfSheets();

        //petla po arkuszach (zakladki)
        for(int i = 0; i < nSheetNumber; i++) {

            //Pobranie arkusza o danym indeksie
            Sheet sheet = wb.getSheetAt(i);

            // ******************** Project ******************
            //model.getProjectList
            //if nie istnieje > dodac
            //list.add()

            Project project = new Project(sheet.getSheetName());

            //check if istnieje w modelu
            //model.getProjectList
            projectNumber = model.getPersonList().get(personNumber).getProjectList().indexOf(project);
            if (projectNumber != -1) {
                System.out.println("Project found");
            } else {
                System.out.println("Project not found");
                //if nie istnieje > dodac; list.add()
                model.getPersonList().get(personNumber).getProjectList().add(project);
                projectNumber = model.getPersonList().get(personNumber).getProjectList().indexOf(project);
            }

            //petla po rekordach
            int j = 0;
            int emptRowCounter = 0;
            boolean booleanEmptyCell = false;
            boolean booleanValueCellMismatch = false;
            while(emptRowCounter < 5) {
                //Pobranie wiersza z danego arkusza
                Row row = sheet.getRow(++j);
                if (row == null) {
                    // wiersz jest pusty; nie można pobrać komórek
                    emptRowCounter++;
                }
                else {  // rekord OK
                    Date dateValue = null;
                    String taskValue = null;
                    double timeValue = 0;

                    //petla po cell-kach
                    for(int k=0; k < 3; k++) {
                        Cell cell = row.getCell(k);
                        if (cell == null) {
                            // komórka pusta; nie można pobrać wartości; nie zapisuj do modelu
                            System.out.println("Pusta komórka!");
                        }
                        else {  // cell-ka OK
                            CellType cellType = cell.getCellType();
                            switch (cellType) {
                                case BLANK: // pusta wartość
                                    //System.out.println("Typ komórki: BLANK!");
                                    booleanEmptyCell = true;
                                    break;
                                case STRING: // wartość tekstowa
                                    if(k != 1) {
                                        booleanValueCellMismatch = true;
                                    }
                                    taskValue = cell.getStringCellValue();
                                    break;
                                case NUMERIC: // wartość numeryczna (zmienno przecinkowa)
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        if(k != 0) {
                                            booleanValueCellMismatch = true;
                                        }
                                        dateValue = cell.getDateCellValue();
                                        //miesiac wez z daty
                                    } else {
                                        if(k != 2) {
                                            booleanValueCellMismatch = true;
                                        }
                                        //System.out.println("Błędny zapis daty!");
                                        timeValue = cell.getNumericCellValue();
                                    }
                                    break;
                                case ERROR: // błąd
                                    //System.out.println("Typ komórki: ERROR!");
                            }

                        }
                    }
                    // ******************** Task ******************
                    //check if istnieje w modelu
                    //model.getTaskList
                    //if nie istnieje > dodac
                    //  out: dopisanie Task-a
                    //  Task task = new Task();
                    //  task.setDate();
                    //  task.setTaskName();
                    //  task.setHoursCount();
                    //list.add()

                    //jezeli komorka nie pusta i poprawne dane: tworzy nowy Task
                    if(!booleanEmptyCell && !booleanValueCellMismatch) {
                        Task task = new Task(dateValue, taskValue, timeValue);

                        //check if istnieje w modelu
                        //model.getProjectList
                        taskNumber = model.getPersonList().get(personNumber).getProjectList().get(projectNumber).getTaskList().indexOf(task);
                        if (taskNumber != -1) {
                            System.out.println("Task found");
                        } else {
                            System.out.println("Task not found");
                            //if nie istnieje > dodac; list.add()
                            model.getPersonList().get(personNumber).getProjectList().get(projectNumber).getTaskList().add(task);
                            taskNumber = model.getPersonList().get(personNumber).getProjectList().get(projectNumber).getTaskList().indexOf(task);
                        }
                    }
                    else {  // if pusta_komorka|bledne_dane: czyszczenie flag przed parsowaniem kolejnego rekordu
                        booleanEmptyCell = false;
                        booleanValueCellMismatch = false;
                    }

                    //System.out.println("dateValue:" + dateValue + ", taskValue: " + taskValue + ", timeValue: " + timeValue);
                }
            }
        }
        //System.out.println(model.toString());
    }

    //write to file
    public void write(String filename, Report report) {
        // zaladowac (sparsowac) excele do modelu
        // path, model
    }
}
