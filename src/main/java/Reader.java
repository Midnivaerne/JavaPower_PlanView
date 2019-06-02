<<<<<<< HEAD:src/Reader.java
=======
import model.Model;
//import org.apache.poi.xssf.usermodel.XSSFSheet;

>>>>>>> 4ece2d295393714161f4ca7c95a23e0ba8e504b6:src/main/java/Reader.java
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;


<<<<<<< HEAD:src/Reader.java
public class Reader {
	
	FilenameFilter filter;
	
//	
//	public static void main(String[] args) {
//	File folder = new File("C:\\");
//	Reader reader = new Reader();
//	
//	
//	reader.getExcels(folder);
//
//	}
	
	public Reader() {
	filter = new FilenameFilter() {
        public boolean accept(File directory, String fileName) {
            return fileName.endsWith(".xls");
        }
      };
	}
	
	public List<File> getExcels(File dataFolder){
		List<File> result = new ArrayList<>();

		File[] listOfFilesWithExt = dataFolder.listFiles(filter);
		File[] listOfFiles = dataFolder.listFiles();
		
		for (File file : listOfFilesWithExt ) {
			result.add(file);
			System.out.println(file.getName());
		}
		
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				System.out.println(file);
				this.getExcels(file);
			}
		}
		
		return result;

		}
=======
        Model model = new Model();
        File file = new File(filename);
        if (!file.exists())
            throw new FileNotFoundException();

        //XSSFSheet workbook;
        // filesystem crawler,
        // rok

        // miesiac

        // excel, pracownicy
        // ExcelHandler ?
        return model;
    }

    private Reader() {
    }
>>>>>>> 4ece2d295393714161f4ca7c95a23e0ba8e504b6:src/main/java/Reader.java
}
