import processing.core.PApplet;

public class Button {
	PApplet parent;
	int x, y, w, h;
	String text;
	int clr;// = parent.color(0,0,0);

	Button(PApplet p, int _x, int _y, int _w, int _h, String _text) {
		this.parent = p;
		this.x = _x;
		this.y = _y;
		this.w = _w;
		this.h = _h;
		this.text = _text;
	}

	public void setColor(int r, int g, int b) {
		this.clr = parent.color(r, g, b);
	}

	public void display() {
		parent.fill(this.clr);
		parent.stroke(this.clr);
		parent.rect(this.x, this.y, this.w, this.h);
		parent.noStroke();
		parent.noFill();
	}

	public boolean isWithin(int px, int py) {
		if (px < this.x) {
			return false;
		} else if (py < this.y) {
			return false;
		} else if (px > this.x + this.w) {
			return false;
		} else if (py > this.y + this.h) {
			return false;
		}
		return true;
	}
}