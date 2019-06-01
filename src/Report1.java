import model.Person;
import model.Project;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class Report1 extends Report {

    private String Year;

    public Report1(String Year){
        this.Year = Year;
    };

    @Override
    public void generate() {

        List<String> persons = new ArrayList<String>();
        List<String> hours = new ArrayList<String>();



        for (Person person : this.getDataModel().getPersonList()) {
            int currentPersonHours = 0;
            persons.add(person.toString());
            for (Project project : person.getProjectList()) {
                for (Task task : project.getTaskList()) {
                    currentPersonHours += task.getHoursCount();
                }
            }
            hours.add(String.valueOf(currentPersonHours));
        }
        this.outputList.add(persons);
        this.outputList.add(hours);

    }




}
