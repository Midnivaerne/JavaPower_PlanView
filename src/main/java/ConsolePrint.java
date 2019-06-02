import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConsolePrint implements Printer {

    private int columnCounter;
    private int rowCounter;
    private List<Integer> columnSizes = new LinkedList<>();
    private List<List<String>> localTable;
    private List<String> singleRow = new ArrayList<>();

    @Override
    public void print(){
        getMaximumColumnSize();
        for (int singleColumnLength : columnSizes) {
            printSignMultipleTimes( (singleColumnLength + (columnCounter*2)), "-");
        }

        System.out.println("");
        rowCounter = localTable.get(0).size();
        for(int i = 0; i < rowCounter; i++) {
            for(int j = 0; j < columnCounter; j++) {
                System.out.print("| " + localTable.get(j).get(i) + " ");
                printSignMultipleTimes(columnSizes.get(j) - localTable.get(j).get(i).length(), " ");
//                singleRow.add(localTable.get(j).get(i));
            }
            System.out.println("|");
        }

        for (int singleColumnLength : columnSizes) {
            printSignMultipleTimes( (singleColumnLength + (columnCounter*2)), "-");
        }

    };

    public ConsolePrint(List<List<String>> inputTable) {
        super();
        localTable = inputTable;
        columnCounter = inputTable.size();
//        columntCounter = inputTable;
    }

    private void getMaximumColumnSize() {
        int maxValue = 0;
        int column = 1;
        for (List<String> singleRow : localTable) {
            for (String singleElement : singleRow ) {
                if(singleElement.length() > maxValue) {
                    maxValue = singleElement.length();
                }
            }
            columnSizes.add(maxValue);
            maxValue = 0;
            column++;
        }
    }

    private void printSignMultipleTimes(int lineLength, String sign){
        for(int i = 0; i<lineLength;i++) {
            System.out.print(sign);
        }
    }
}
