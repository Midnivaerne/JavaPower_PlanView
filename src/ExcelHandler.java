import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class ExcelHandler {

    //fields
    private File file;
    private FileOutputStream fileOut;

    private XSSFWorkbook workbook;
    private Sheet sheet;
    private Row row;
    private Cell cell;
    private XSSFWorkbook workbook;

    //path to file
    //ktos podaje nowe pliki
    //in: parsowanie pojedynczego excella
    //obsluga zakladek
    //out: dopisanie do modelu

    //table to write


    //methods
    //read form file
    //write to file
    public void write(String filename, Report report) {
        // zaladowac (sparsowac) excele do modelu
        // path, model
    }
}
