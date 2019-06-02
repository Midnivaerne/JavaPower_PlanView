import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConsolePrint implements Printer {

    private int columnCounter;
    private int rowCounter;
    private List<Integer> columnSizes = new LinkedList<>();
    private List<Integer> tmpColumnSizes = new LinkedList<>();
    private List<List<String>> localTable;
    private List<String> singleRow = new ArrayList<>();
    private Report report;

    @Override
    public void print(){
        int counter = 0;
        getMaximumColumnSize();
//        System.out.println("Max column size" + columnSizes);
        for (int singleColumnLength : columnSizes) {
            printSignMultipleTimes( (singleColumnLength), "-");
        }
        printSignMultipleTimes((columnCounter*3) +1, "-");

        System.out.println("");
        for(String singleCell : report.getColumnHeader()){
            System.out.print("| " + singleCell + " ");
            printSignMultipleTimes(columnSizes.get(counter) - singleCell.length(), " ");
            counter++;
        }
        System.out.println("|");

        for (int singleColumnLength : columnSizes) {
            printSignMultipleTimes( (singleColumnLength), "-");
        }
        printSignMultipleTimes((columnCounter*3) +1, "-");

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
            printSignMultipleTimes( (singleColumnLength), "-");
        }
        printSignMultipleTimes((columnCounter*3) +1, "-");

        System.out.println("\n\n\n");
    };

    public ConsolePrint(List<List<String>> inputTable, Report argReport) {
        super();
        localTable = inputTable;
        columnCounter = inputTable.size();
        report = argReport;
    }

    private void getMaximumColumnSize() {
        int maxValue = 0;
        int column = 1;
        int counter = 0;
        for (List<String> singleRow : localTable) {
            for (String singleElement : singleRow ) {
                if(singleElement.length() > maxValue) {
                    maxValue = singleElement.length();
                }
            }
            columnSizes.add(maxValue);
        }

        for(int singleSize : columnSizes){
            if(singleSize < report.getColumnHeader().get(counter).length()) {
                tmpColumnSizes.add(report.getColumnHeader().get(counter).length());
            } else {
                tmpColumnSizes.add(singleSize);
            }
            counter++;
        }
        columnSizes = tmpColumnSizes;

        maxValue = 0;
        column++;
    }

    private void printSignMultipleTimes(int lineLength, String sign){

        for(int i = 0; i<lineLength;i++) {
            System.out.print(sign);
        }
    }
}
