import model.Person;
import model.Project;
import model.Task;

import java.util.*;

public class Report3 extends Report {

    private String Surname;
    private String Name;

    public Report3(String Name, String Surname, String Year){
        this.Year = Year;
        this.Name = Name;
        this.Surname = Surname;
    };


    @Override
    public void generate(){

        reportHeader = "Raport 3 z roku "+ Year + "Dla pracownika" + Name + Surname;

        columnHeader.add("Miesiąc");
        columnHeader.add("Projekt");
        columnHeader.add("Przepracowane godziny");

        Map<Integer, TreeMap<String,Double>> dictionary = new HashMap<>();



        for (Person person: this.getDataModel().getPersonList()){
            if((person.getName() == Name) && (person.getSurname() == Surname)){
                for (Project project: person.getProjectList()){
                    for (Task task: project.getTaskList()){
                        if(!dictionary.containsKey(task.getDate().getMonth())){
                            dictionary.put(Integer.valueOf(task.getDate().getMonth()), new TreeMap<>());
                        }
                        if (!dictionary.get(Integer.valueOf(task.getDate().getMonth())).containsKey(project.getName())){
                            dictionary.get(Integer.valueOf((task.getDate().getMonth()))).put(project.getName(),0.0);
                        }
                        dictionary.get(Integer.valueOf((task.getDate().getMonth()))).put(project.getName(),dictionary.get(Integer.valueOf((task.getDate().getMonth()))).get(project.getName())+task.getHoursCount());
                    }
                }
            }
        }
        List<String> monthList = new ArrayList<>();
        List<String> projectList = new ArrayList<>();
        List<String> hoursList = new ArrayList<>();

        for (Integer month: dictionary.keySet()) {
            for (String projectName: dictionary.get(month).keySet()){
                monthList.add(String.valueOf(month));
                projectList.add(projectName);
                hoursList.add(String.valueOf(dictionary.get(month).get(projectName)));

                }
            }

        outputList.add(monthList);
        outputList.add(projectList);
        outputList.add(hoursList);
    }


}
