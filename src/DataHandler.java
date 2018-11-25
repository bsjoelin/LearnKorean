import processing.data.*;
import java.io.*;

public class DataHandler {
	
	public static JSONArray loadDataToJSONArray(String filepath) {
		File JSONfile = new File(filepath);
		Reader r;
		JSONArray JArray;
		try {
			r = new FileReader(JSONfile);
			JArray = new JSONArray(r);
			r.close();
		} catch (FileNotFoundException e) {
			System.out.println("Filepath doesn't contain JSON file.");
			JArray = new JSONArray();
		} catch (IOException e) {
			System.out.println("File couldn't close.");
			JArray = new JSONArray();
		}
		return JArray;
	}
	
	public static JSONObject loadDataToJSONObject(String filepath) {
		File JSONfile = new File(filepath);
		Reader r;
		JSONObject JObj;
		try {
			r = new FileReader(JSONfile);
			JObj = new JSONObject(r);
			r.close();
		} catch (FileNotFoundException e) {
			System.out.println("Filepath doesn't contain JSON file.");
			JObj = new JSONObject();
		} catch (IOException e) {
			System.out.println("File couldn't close.");
			JObj = new JSONObject();
		}
		return JObj;
	}	
}
