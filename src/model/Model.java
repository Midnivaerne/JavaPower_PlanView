package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    private List<Person> personList;

    public Model() {
        personList = new ArrayList<>();
    }
}
