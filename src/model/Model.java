package model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private List<Person> personList;
	
	public Model(){
		personList = new LinkedList<>();
	}
	
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

// nie dzia³a do poprawy !!!    
//    public void addPersonToModel(List<Person> person){
//    	this.personList.add((Person) person);
//    }
    
}
