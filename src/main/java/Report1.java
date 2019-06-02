import model.Person;
import model.Project;
import model.Task;

import java.time.Year;
import java.util.*;

public class Report1 extends Report {

    public Report1(String Year){
        this.Year = Year;
    };

    @Override
    public void generate() {

        reportHeader = "Raport 1 z roku "+ Year;

        columnHeader.add(0,"Nazwisko i imię");
        columnHeader.add(1, "Przepracowane godziny");

        Map<String, String> dictionary = new TreeMap<String, String>();

        for (Person person : this.getDataModel().getPersonList()) {
            double currentPersonHours = 0;
            for (Project project : person.getProjectList()) {
                for (Task task : project.getTaskList()) {
                    currentPersonHours += task.getHoursCount();
                }
            }
            dictionary.put(person.toString(),String.valueOf(currentPersonHours));
        }

        this.outputList.add(new ArrayList<>(dictionary.keySet()));
        this.outputList.add(new ArrayList<>(dictionary.values()));

    }




}
