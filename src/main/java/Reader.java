import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	
	FilenameFilter filter;

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
}
