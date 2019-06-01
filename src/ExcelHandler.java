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

    //aaa

    //path to file
    //ktos podaje nowe pliki
    //in: parsowanie pojedynczego excella
    //obsluga zakladek
    //out: dopisanie do modelu

    //table to write
    // HELLO WORLD 123

    //methods
    //read form file
    public void read(String filename) {

    }
    //write to file
    public void write(String filename, Report report) {
        // zaladowac (sparsowac) excele do modelu
        // path, model
    }
}
