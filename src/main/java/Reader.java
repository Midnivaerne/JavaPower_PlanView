import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	
	FilenameFilter filter;

	public List<File> getResult() {
		return result;
	}

	List<File> result = new ArrayList<>();


	public Reader() {
	filter = new FilenameFilter() {
        public boolean accept(File directory, String fileName) {
            return fileName.endsWith(".xls");
        }
      };
	}
	
	public List<File> getExcels(File dataFolder){

		File[] listOfFilesWithExt = dataFolder.listFiles(filter);
		File[] listOfFiles = dataFolder.listFiles();
		
		for (File file : listOfFilesWithExt ) {
			result.add(file);
//			System.out.println(file.getName());
		}
		
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
//				System.out.println(file);
				this.getExcels(file);
			}
		}
		return result;

		}

	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
	{

		// Create a new ArrayList
		ArrayList<T> newList = new ArrayList<T>();

		// Traverse through the first list
		for (T element : list) {

			// If this element is not present in newList
			// then add it
			if (!newList.contains(element)) {

				newList.add(element);
			}
		}

		// return the new list
		return newList;
	}
}
