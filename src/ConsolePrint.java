import java.util.List;

public class ConsolePrint extends Printer {

    @Override
    public void print(){};

    private int rowCounter;
    private int columntCounter;
    private List<Integer> columnSizes;
    private List<List<String>> localTable;

    public ConsolePrint(List<List<String>> inputTable) {
        super();
        localTable = inputTable;
        rowCounter = inputTable.size();
        columntCounter = inputTable;
    }

    private void getMaximumColumnSize() {
        int maxValue = 0;
        for (List<String> singleRow : localTable) {
            for (String singleElement : singleRow ) {
                if(singleElement.length() > maxValue) {
                    maxValue = singleElement.length();
                }
            }
            columnSizes.add(maxValue);
        }
    }

    private void printHeader() {

    }
}
