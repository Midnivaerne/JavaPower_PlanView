import model.Model;

import java.util.List;
import java.util.ArrayList;

public abstract class Report {

    protected List<String> columnHeader = new ArrayList<String>();
    protected String Year;
    protected List<List<String>> outputList = new ArrayList<>();
    protected String reportHeader;
    private Model DataModel = new Model();

    public abstract void generate();

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

    public List<String> getColumnHeader() {
        return columnHeader;
    }

    public String getReportHeader() {
        return reportHeader;
    }
}
