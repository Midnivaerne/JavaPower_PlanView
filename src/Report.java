import model.Model;

import java.util.List;

public abstract class Report {

    public abstract List<List<String>> generate();

    private Model DataModel = new Model();

    public Model getDataModel() {
        return DataModel;
    }

    public void setDataModel(Model dataModel) {
        DataModel = dataModel;
    }

    //  public Model load(String filePath){
    //      return;
  //  };
}
