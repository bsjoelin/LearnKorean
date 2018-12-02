import processing.core.*;

public class SceneManager {

	public static class MainMenu extends Scene {

		MainMenu(PApplet p){
			this.parent = p;
			this.backgroundColor = this.parent.color(150);
			this.buttons.add(new Button(p, 0.4f, 0.4f, 0.18f, 0.12f, "Test"));
			this.buttons.add(new Button(p, 0.6f, 0.4f, 0.18f, 0.12f, "Test"));
			this.buttons.add(new Button(p, 0.5f, 0.56f, 0.38f, 0.12f, "Test"));
		}

		public void display() {
			if(this.backgroundImage != null) {
				this.parent.image(this.backgroundImage, 0, 0);
			} else {
				this.parent.background(this.backgroundColor);
			}

			for(Button b : this.buttons) {
				b.display();
			}
		}
	}


	public static class TranslateTask extends Scene {

		TranslateTask(PApplet p){
			this.parent = p;
			this.backgroundColor = this.parent.color(150);
			this.textboxes.add(new TextBox(p, 0.5, 0.3, 0.3, 0.1));
		}

		public void display() {
			if(this.backgroundImage != null) {
				this.parent.image(this.backgroundImage, 0, 0);
			} else {
				this.parent.background(this.backgroundColor);
			}

			for(Button b : this.buttons) {
				b.display();
			}
		}
	}


	public static class ChooseLesson extends Scene {

		ChooseLesson(PApplet p){

		}

		public void display() {

		}
	}



}
