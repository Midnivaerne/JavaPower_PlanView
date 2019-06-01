import model.Person;
import model.Project;
import model.Model;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public void report1Test() {
        Report1 r1 = new Report1("2000");
        Model m = new Model();
        Person p1 = new Person();
        Person p2 = new Person();
        Project pr1 = new Project();
        Task t1 = new Task();
        Task t2 = new Task();


        ArrayList<Person> plist = new ArrayList<Person>();
        ArrayList<Project> prlist = new ArrayList<Project>();
        ArrayList<Task> tlist = new ArrayList<Task>();

        p1.setName("Adaś");
        p1.setSurname("Miałczyński");
        p2.setName("Jerzy");
        p2.setSurname("Zwierz");
        t1.setHoursCount(20);
        t2.setHoursCount(100);
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

        List<List<String>> outlist = r1.generate();

        System.out.println(outlist.get(0).get(0) + " - " + outlist.get(1).get(0));
        System.out.println(outlist.get(0).get(1) + " - " + outlist.get(1).get(1));
    }






}
