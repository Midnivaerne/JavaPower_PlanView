import model.Person;
import model.Project;
import model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Report4 extends Report {

    private String Surname;
    private String Name;

    public Report4(String Name, String Surname, String Year){
        this.Year = Year;
        this.Name = Name;
        this.Surname = Surname;
    };

    @Override
    public void generate(){

        reportHeader = "Raport 4 z roku "+ Year + "Dla pracownika" + Name + Surname;

        columnHeader.add(0,"Projekt");
        columnHeader.add(1, "Przepracowane godziny");

        Map<String, Double> outMap = new TreeMap<String, Double>();

        for (Person person: this.getDataModel().getPersonList()) {
            if((person.getName().equals(Name)) && person.getSurname().equals(Surname)){
                for (Project project: person.getProjectList()) {
                    for (Task task: project.getTaskList()) {
                        if(outMap.containsKey(project.getProjectName())) {
                        }else{
                            outMap.put(project.getProjectName(),0.0);
                        }
                        outMap.put(project.getProjectName(), outMap.get(project.getProjectName())+task.getHoursCount());
                    }
                }
            }
        }

        List<String> hoursList = new ArrayList<String>();
        for (Double hoursValue: outMap.values()){
            hoursList.add(String.valueOf(hoursValue));
        }

        this.outputList.add(new ArrayList<>(outMap.keySet()));
        this.outputList.add(new ArrayList<>(hoursList));
    }
}
