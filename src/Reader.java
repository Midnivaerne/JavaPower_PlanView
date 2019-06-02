import model.Model;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.File;
import java.io.FileNotFoundException;

public class Reader {

    private static Reader ourInstance = new Reader();

    public static Reader getInstance() {
        return ourInstance;
    }

    public Model parseData(String filename) throws FileNotFoundException {
        if (filename == null)
            return null;

        Model model = new Model();
        File file = new File(filename);
        if (!file.exists())
            throw new FileNotFoundException();

        XSSFSheet workbook;
        // filesystem crawler,
        // rok

        // miesiac

        // excel, pracownicy
        // ExcelHandler ?
        return model;
    }

    private Reader() {
    }
}
