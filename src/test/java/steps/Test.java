package steps;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;

public class Test {

	// DataTable implementation as List of List 
	public void enterDetails(DataTable table) {
		List<List<String>> data = table.asLists(String.class);
		// Processing the List of List with for loop
		for(int i = 1; i < data.size(); i++) {
			data.get(i).get(0);
		}
		// Processing the List of List with for each loop
		for(List<String> d : data) {
		    d.get(0);
		}
	}
	// DataTable implementation as List of Map
	public void enterInfo(DataTable data) {
		List<Map<String, String>> testD = data.asMaps(String.class, String.class);
		// Processing the List of Map with for loop
		for(int i = 1; i < testD.size(); i++) {
			testD.get(i).get("username");
		}
		// Processing the List of Map with for each loop
		for(Map<String, String> ss : testD) {
			String username = ss.get("username");
			String password = ss.get("password");
		}
	}
	
}
