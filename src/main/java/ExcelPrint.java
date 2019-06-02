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
    private String excelName;
    private List<String> header;


    public ExcelPrint(List<List<String>> inputTable, File path, String excelName, List<String> header) {
        super();
        localTable = inputTable;
        columnCounter = inputTable.size();
        this.path = path;
        this.excelName = excelName;
        this.header = header;

    }

    @Override
    public void print() throws IOException{
        Workbook wb = new XSSFWorkbook();
        String pathToReport = path.getAbsolutePath();
        FileOutputStream fos = new FileOutputStream(pathToReport+"\\"+header +".xlsx");

        Sheet sh = wb.createSheet(excelName);

        sh.createRow(0);
        int headerLength = header.size();
        int i = 0;
        for (String head : header){
            sh.getRow(0).createCell(i).setCellValue(head);
            i++;
        }

        rowCounter = localTable.get(0).size();
        for(i = 0; i < rowCounter; i++) {
            sh.createRow(i+1);
            for(int j = 0; j < columnCounter; j++) {
                sh.getRow(i).createCell(j).setCellValue(localTable.get(j).get(i));

            }
        }


        wb.write(fos);
        fos.close();

    };
}
