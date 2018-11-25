import processing.data.*;
import java.util.List;
import java.util.ArrayList;

public class Lessons {
	private List<Lesson> lessons = new ArrayList<>();
	
	// Automatically loads the lessons on object creation.
	Lessons(String filepath){
		loadLessons(filepath);
	}
	
	// Called on initiation of a Lessons object.
	public void loadLessons(String filepath) {
		// Get the file paths for all lesson files.
		List<String> lessonPaths = new ArrayList<>();
		JSONArray filepaths = DataHandler.loadDataToJSONArray(filepath);
		for(int i = 0; i < filepaths.size(); i++) {
			lessonPaths.add(filepaths.getString(i));
		}
		
		// Load all the lessons into memory.
		for(String str : lessonPaths) {
			JSONObject JObj = DataHandler.loadDataToJSONObject(str); 
			Lesson l = new Lesson(JObj.getString("name"),JObj.getJSONArray("exercises"));
			this.lessons.add(l);
		}
	}
	
	// Getter to access the lessons.
	public List<Lesson> getLessons(){
		return this.lessons;
	}
	

	public class Lesson {
		private String name;
		private List<Exercise> exercises = new ArrayList<>();
		
		// Constructor automatically creates the exercise objects.
		Lesson(String _name, JSONArray JArray){
			this.name = _name;
			for(int i = 0; i < JArray.size(); i++) {
				// Get the current exercise.
				JSONObject entry = JArray.getJSONObject(i);
				
				// Create local variables to ease readability.
				String task = entry.getString("task");
				String correct = entry.getString("correct");
				String hangul = entry.getString("hangul");
				int answeredCor = entry.getInt("answeredCorrectly");
				
				// Initiate the current exercise and add it to the list.
				Exercise e = new Exercise(task, correct, hangul, answeredCor);
				exercises.add(e);
			}
		}
		
		// Getter for lesson name.
		public String getName() {
			return this.name;
		}
		
		// Getter for the exercises.
		public List<Exercise> getExercises(){
			return this.exercises;
		}


		public class Exercise {
			String task;
			String correctAnswer;
			String hangulText;
			int answeredCorrectly;

			Exercise(String t, String cor, String han, int ansCor){
				this.task = t;
				this.correctAnswer = cor;
				this.hangulText = han;
				this.answeredCorrectly = ansCor;
			}

		}
	}
}