import model.Person;
import model.Project;
import model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Report2 extends Report {

    public Report2(String Year){
        this.Year = Year;
    };

    @Override
    public void generate(){

        reportHeader = "Raport 2 z roku "+ Year;

        columnHeader.add(0,"Projekt");
        columnHeader.add(1, "Przepracowane godziny");

        Map<String, Double> outMap = new TreeMap<String, Double>();

        for (Person person: this.getDataModel().getPersonList()){
            for (Project project : person.getProjectList()) {
                for (Task task: project.getTaskList()) {
                    if(outMap.containsKey(project.getProjectName())) {
                    }else{
                        outMap.put(project.getProjectName(),0.0);
                    }
                    outMap.put(project.getProjectName(), outMap.get(project.getProjectName())+task.getHoursCount());
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
