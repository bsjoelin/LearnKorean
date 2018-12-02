import processing.core.*;

public class Button {
	private PApplet parent;
	// The position is relative to the size of the canvas.
	private float x, y, w, h;
	private String text;
	private int clr;
	private int strokeClr;
	private int textClr;

	// The input parameters _x, _y, _w, _h are relative to applet size, so are in the range [0;1].
	Button(PApplet p, float _x, float _y, float _w, float _h, String _text) {
		this.parent = p;
		this.x = _x * this.parent.width;
		this.y = _y * this.parent.height;
		this.w = _w * this.parent.width;
		this.h = _h * this.parent.height;;
		this.text = _text;
		this.setDefaults();
	}

	// The input parameters _x, _y, _w, _h are relative to applet size, so are in the range [0;1].
	Button(PApplet p, double _x, double _y, double _w, double _h, String _text) {
		this.parent = p;
		this.x = (float)_x * this.parent.width;
		this.y = (float)_y * this.parent.height;
		this.w = (float)_w * this.parent.width;
		this.h = (float)_h * this.parent.height;;
		this.text = _text;
		this.setDefaults();
	}

	private void setDefaults() {
		this.setColor(255, 255, 255);
		this.setStrokeColor(0, 0, 0);
		this.setTextColor(0, 0, 0);
	}

	public void setColor(int r, int g, int b) {
		this.clr = parent.color(r, g, b);
	}

	public void setStrokeColor(int r, int g, int b) {
		this.strokeClr = parent.color(r, g, b);
	}

	public void setTextColor(int r, int g, int b) {
		this.textClr = parent.color(r, g, b);
	}

	public void display() {
		parent.fill(this.clr);
		parent.stroke(this.strokeClr);

		parent.rectMode(PConstants.CENTER);
		parent.rect(this.x, this.y, this.w, this.h);

		parent.fill(this.textClr);
		parent.textAlign(PConstants.CENTER, PConstants.CENTER);
		parent.text(this.text, this.x, this.y);

		parent.noStroke();
		parent.noFill();
	}

	// Determines whether a set of coordinates (x,y) lies within the bounds of the button.
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