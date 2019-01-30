import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Collections;			// Used to sort arraylists

import org.json.simple.JSONArray;		// Used to manipulate the JSON data
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;   // Used to convert arraylists to JSON objects

public class StudentSort {

	public static void main(String[] args) {
	try {
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new FileReader("students.json")); // Parsed JSON object into an array
		ArrayList<String> nameList =  new ArrayList<String>();  				// Created arraylists to store the data
		ArrayList<Double> gradeList = new ArrayList<Double>();
		for (Object o : a)													// Looped through arraylist and added names and grades to separate arraylists
		{
			JSONObject person = (JSONObject) o;
			
			String name = (String) person.get("name");
			nameList.add(name);
			
			
			Double grade = (Double) person.get("grade");
			gradeList.add(grade);
			
		}
		Collections.sort(nameList);                        // Sorting names into alphabetical order
		Collections.sort(gradeList);					   // Sorting grades from min to max
		
		String nameJson = new Gson().toJson(nameList);      // Converting the arraylists into a JSON object
		String gradeJson =  new Gson().toJson(gradeList);
		
		FileWriter nameFile =  new FileWriter("students_name.json");  // Writing the JSON object into newly written files
		nameFile.write(nameJson);
		FileWriter gradeFile =  new FileWriter("students_grade.json");
		gradeFile.write(gradeJson);
	}
	 catch (Exception e) {
	        e.printStackTrace();
    }
	}
	
}
