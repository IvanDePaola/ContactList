package Project.appClasses;

import java.util.TreeSet;

import Project.ServiceLocator;
import Project.abstractClasses.Model;

/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * @author Brad Richards
 */
public class App_Model extends Model {
	ServiceLocator serviceLocator;
    private int value;
	protected TreeSet<Contact> treeContacts = new TreeSet<Contact>();
    
    public App_Model() {
        value = 0;
        
        serviceLocator = ServiceLocator.getServiceLocator();        
        serviceLocator.getLogger().info("Application model initialized");
    }
    
    
    
    
    public void fillSet() {
    	this.treeContacts.add(new Contact("F", "L", 000, "x.x" ));
    	
    }
    
    
    //template methods
    public int getValue() {
        return value;
    }
    
    public int incrementValue() {
        value++;
        serviceLocator.getLogger().info("Application model: value incremented to " + value);
        return value;
    }
}
