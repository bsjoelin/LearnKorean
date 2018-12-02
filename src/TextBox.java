import processing.core.*;

public class TextBox {
	private PApplet parent;
	// The position is relative to the size of the canvas.
	private float x, y, w, h;
	private String defaultText = "Type to input letters.";
	private String text = "";
	private int clr;
	private int strokeClr;
	private int textClr;

	TextBox(PApplet p, float _x, float _y, float _w, float _h){
		this.parent = p;
		this.x = _x*this.parent.width;
		this.y = _y*this.parent.height;
		this.w = _w*this.parent.width;
		this.h = _h*this.parent.height;
		setDefaults();
	}
	
	TextBox(PApplet p, double _x, double _y, double _w, double _h){
		this.parent = p;
		this.x = (float)_x*this.parent.width;
		this.y = (float)_y*this.parent.height;
		this.w = (float)_w*this.parent.width;
		this.h = (float)_h*this.parent.height;
		setDefaults();
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

		parent.textAlign(PConstants.LEFT, PConstants.CENTER);
		if(this.text.equals("")) {
			parent.fill(222);
			parent.text(this.defaultText, this.x + 0.02f * this.w, this.y);
		} else {
			parent.fill(this.textClr);
			parent.text(this.text, this.x + 0.02f * this.w, this.y);
		}

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
