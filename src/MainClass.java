import processing.core.PApplet;

public class MainClass extends PApplet{

	Button b;
	String hangulJSON = "data\\hangul.json";
	Hangul hangul = new Hangul();
	Lessons lessons;
	Scene currentScene;

	public static void main(String[] args) {
		PApplet.main("MainClass");

	}

	public void settings() {
		size(1024,576);
	}

	public void setup() {
		currentScene = new SceneManager.MainMenu(this);
		hangul.loadData(hangulJSON);
		lessons = new Lessons("data\\lessons.json");
		textFont(createFont("malgun gothic",24));
		textAlign(LEFT,TOP);
	}

	public void draw() {
		background(0);
		currentScene.display();
		
		fill(0);
		text(hangul.convertToHangul("ss"),15,15);
	}
	
	public void mousePressed() {
		
	}
}
