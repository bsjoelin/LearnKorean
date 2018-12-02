import processing.core.*;
import java.util.*;

public abstract class Scene {
	protected PApplet parent;
	protected int backgroundColor;
	protected PImage backgroundImage = null;
	protected List<Button> buttons = new ArrayList<Button>();
	protected List<TextBox> textboxes = new ArrayList<TextBox>();
	
	public abstract void display();
	
}