import model.Model;

import java.util.List;
import java.util.ArrayList;

public abstract class Report {

    public abstract void generate();

    protected List<List<String>> outputList = new ArrayList<>();

    private Model DataModel = new Model();


    public List<List<String>> getOutputList() {
        return outputList;
    }
    public void setOutputList(List<List<String>> outputList) {
        this.outputList = outputList;
    }

    public Model getDataModel() {
        return DataModel;
    }
    public void setDataModel(Model dataModel) {
        DataModel = dataModel;
    }

}
