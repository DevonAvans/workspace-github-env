package controller;

import java.util.ArrayList;

import model.Color;
import view.ColorPane;
import view.DatabaseConnectionPane;

public class ColorController {

	private ArrayList<Color> c;
	private ColorPane p;
	private DatabaseConnectionPane dcp;
	
	public ColorController() {
		c = new ArrayList<Color>();
		p = new ColorPane();
		dcp = new DatabaseConnectionPane(c);
	}
	
}
