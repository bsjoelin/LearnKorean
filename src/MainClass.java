import processing.core.PApplet;

public class MainClass extends PApplet{

	Button b;
	String hangulJSON = "data\\hangul.json";
	Hangul hangul = new Hangul();
	Lessons lessons;

	public static void main(String[] args) {
		PApplet.main("MainClass");

	}

	public void settings() {
		size(1024,576);
	}

	public void setup() {
		b = new Button(this, 50, 50, 20, 20, "Hey");
		b.setColor(255, 255, 255);
		hangul.loadData(hangulJSON);
		lessons = new Lessons("data\\lessons.json");
		textFont(createFont("malgun gothic",24));
		textAlign(LEFT,TOP);
	}

	public void draw() {
		b.display();
		fill(0);
		text(hangul.convertToHangul("ss"),15,15);
	}
}
