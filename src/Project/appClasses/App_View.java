package Project.appClasses;

import java.util.Locale;
import java.util.logging.Logger;

import Project.ServiceLocator;
import Project.abstractClasses.View;
import Project.commonClasses.Translator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * @author Brad Richards
 */
public class App_View extends View<App_Model> {
	//behälter definieren
		protected Menu menuFile, menuFileLanguage, menuHelp;
	    Label lblNumber;
	    Button btnClick, plusButton, searchButton, groupButton;
	    

	    //Borderpane as root definieren
	    protected BorderPane root;
	    
	    protected ListView<Contact> contactList;
	    
	    protected HBox buttonBox, searchBar, bottom;
	    
	    protected TextField searchField;
	    protected VBox center, centerContact, centerGroup;
	    protected MenuBar menuBar;
	    protected ImageView searchIcon;
	    
	   // protected static Image SEARCHICON = new Image("link");
		
	    
	    
		public App_View(Stage stage, App_Model model) {
	        super(stage, model);
	        ServiceLocator.getServiceLocator().getLogger().info("Application view initialized");
	    }

		@Override //template method -- add everything in the GUI
		protected Scene create_GUI() {
		    //template menu and logger
			ServiceLocator sl = ServiceLocator.getServiceLocator();  
		    Logger logger = sl.getLogger();
		  
		    menuBar = new MenuBar();
		    menuFile = new Menu();
		    menuFileLanguage = new Menu();
		    menuFile.getItems().add(menuFileLanguage);
		    
		   
		    this.root = new BorderPane();	    
		    
		    //template for the language options
	       for (Locale locale : sl.getLocales()) {
	           MenuItem language = new MenuItem(locale.getLanguage());
	           menuFileLanguage.getItems().add(language);
	           language.setOnAction( event -> {
					sl.getConfiguration().setLocalOption("Language", locale.getLanguage());
	                sl.setTranslator(new Translator(locale.getLanguage()));
	                updateTexts();
	            });
	           
	        //implement ListView
	           this.contactList = new ListView<Contact>();
	           //load the data into the list
	           super.model.fillSet();
	           for(Contact c : super.model.treeContacts) {
	    		   
	    		   
	       	   	this.contactList.getItems().add(c);
	       	    }
	           
	           
	        //add new contactbutton
	           
	           this.plusButton = new Button("plus");
	           
	       // add a button for the grouping
	           this.groupButton = new Button("group");
	           
	       //HBox containing buttons
	           this.buttonBox = new HBox();
			   
			   this.buttonBox.getChildren().addAll(this.groupButton, this.plusButton);
			   
			 //define search bar
			   this.searchBar = new HBox();
			   this.searchBar.getStyleClass().add("searchBar");
			   
			   this.searchField = new TextField("txt");
			   this.searchField.getStyleClass().add("searchField");
			   
			   
			   this.searchButton = new Button("search");
			   this.searchButton.getStyleClass().add("searchButton");
			   
			   //this.searchIcon = new ImageView(SEARCHICON);
			   //this.searchButton.setGraphic(this.searchIcon);
			   //this.searchIcon.setFitHeight(25);
			   //this.searchIcon.setFitWidth(25);
			   
			   
			   
			   this.searchBar.getChildren().addAll(this.searchField, this.searchButton);
			   HBox.setHgrow(this.searchField, Priority.ALWAYS);
			   
			   
			   //VBox Center wird gefüllt
			   this.center = new VBox();
			   this.center.getStyleClass().add("center");
			   this.center.getChildren().addAll(this.searchBar, this.contactList);
			   VBox.setVgrow(this.contactList, Priority.ALWAYS);
			   
			   this.root.setTop(this.menuBar);
			   this.root.setCenter(this.center);
			   this.bottom = new HBox();
			   this.bottom.getChildren().addAll(this.buttonBox);
			   this.root.setBottom(this.bottom);
			   
			   
			   //TODO: contact view -- save btn, update btn
	           
	        }
		    //rest of template
	        menuHelp = new Menu();
		    menuBar.getMenus().addAll(menuFile, menuHelp);
			
			/*
			 * GridPane root = new GridPane();
			root.add(menuBar, 0, 0);
			
			lblNumber = new Label();
	        lblNumber.setText(Integer.toString(model.getValue()));
	        lblNumber.setMinWidth(200);
	        lblNumber.setAlignment(Pos.BASELINE_CENTER);
	        this.root.add(lblNumber, 0, 1);
	        
	        btnClick = new Button();
	        btnClick.setMinWidth(200);
	        root.add(btnClick, 0, 2);
	        */
	        updateTexts();
			
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(
	                getClass().getResource("app.css").toExternalForm());
	        return scene;
		}
		
		   protected void updateTexts() {
		       Translator t = ServiceLocator.getServiceLocator().getTranslator();
		        
		        // The menu entries
		       menuFile.setText(t.getString("program.menu.file"));
		       menuFileLanguage.setText(t.getString("program.menu.file.language"));
	           menuHelp.setText(t.getString("program.menu.help"));
		        
		        // Other controls
	           //btnClick.setText(t.getString("button.clickme"));
	           
	           stage.setTitle(t.getString("program.name"));
		    }
}