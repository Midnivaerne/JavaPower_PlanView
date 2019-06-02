import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPrint implements Printer {

    private int columnCounter;
    private int rowCounter;
    private List<Integer> columnSizes = new LinkedList<>();
    private List<List<String>> localTable;
    private File path;
    private int reportType;


    public ExcelPrint(List<List<String>> inputTable, File path, int reportType) {
        super();
        localTable = inputTable;
        columnCounter = inputTable.size();
        this.path = path;
        this.reportType = reportType;

    }

    @Override
    public void print() throws IOException{
        Workbook wb = new XSSFWorkbook();
        String pathToReport = path.getAbsolutePath();
        FileOutputStream fos = new FileOutputStream(pathToReport+"\\report"+reportType+".xlsx");

        Sheet sh = wb.createSheet("report"+reportType);

        rowCounter = localTable.get(0).size();
        for(int i = 0; i < rowCounter; i++) {
            sh.createRow(i);
            for(int j = 0; j < columnCounter; j++) {
                sh.getRow(i).createCell(j).setCellValue(localTable.get(j).get(i));

            }
        }


        wb.write(fos);
        fos.close();

    };
}
