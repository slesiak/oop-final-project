/*Sheila Lesiak
 * CPSC 24500 Final Project
 * The name of my project is RecycleApp (not very original), and I worked on this by myself.
 * The purpose of the project is to create an app where one can search an object or material
 * and the app will let them know if it is recyclable and where they can recycle it. 
 * One just needs to type the name of the object or material into the text bar and press the search button, 
 * then the results will display. I used JSON serialization.
 * Future enhancements I would like to make are adding more objects and materials that can be searched
 * and put them all in a database. 
 * Also, adding more ways of recycling and other things to with the materials/objects, such as ways of reusing them,
 * especially for those that I found are not recyclable. I would like to add these to the database as well. 
 * I also think it would be really cool if the app could get one's GPS location 
 * and tell them the nearest location for recycling.
 * Other enhancements would be adding to the aesthetics, so it is not just a boring window.*/

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

class RecycleData {
	public RecycleData(String type, String material) {
	}
	
}
class RecycleJSON {
	//read from JSON
	public static ArrayList<RecycleData> readRecycleDataFromJSON(String fileName) {
		try {
			ArrayList<RecycleData> objects = new ArrayList<RecycleData>();
			FileReader reader = new FileReader(new File(fileName));
			JSONParser parser = new JSONParser();
			JSONObject mainObj = (JSONObject)parser.parse(reader);
			JSONArray objectsArray = (JSONArray)mainObj.get("objects");
			Iterator itr = objectsArray.iterator();
			String type, material;
			while (itr.hasNext()) {
				JSONObject object = (JSONObject)itr.next();
				type = (String)object.get("type");
				material = (String)object.get("material");
				objects.add(new RecycleData(type,material));
			}
			return objects;
		} catch (Exception e) {
			return null;
		}
		
	}
}
class Search {
	//implement search of what is typed into text box
}

class Results {
	//display results
}

class AppWindow extends JFrame {
	public void setupUI() {
		setTitle("Please Recycle!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,500,300);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        JPanel panNorth = new JPanel();
        JTextField title = new JTextField("Enter an object or material you want to recycle:");
        panNorth.add(title);
        title.setEditable(false);
        c.add(panNorth, BorderLayout.NORTH);
        
        JPanel panWest = new JPanel();
        JTextField searchBar = new JTextField(25);
        panWest.add(searchBar);
        c.add(panWest, BorderLayout.WEST);
        
        JPanel panEast = new JPanel();
        JButton search = new JButton("Is this recyclable?!");
        search.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e) {
        		//Calls search
        	}
        });
        panEast.add(search);
        c.add(panEast, BorderLayout.EAST);
        
        JPanel panSouth = new JPanel();
        //add view of results from search
        c.add(panSouth, BorderLayout.SOUTH);
	}
	public AppWindow() {
		setupUI();
	}
}

public class RecycleApp {
	public static void main(String[] args) {
		AppWindow aw = new AppWindow();
		aw.setVisible(true);
	}
}
