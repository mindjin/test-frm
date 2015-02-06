package com.sl.data;

public class Factory {
private static ElementDAO elementDAO = null;
private static FormDAO formDAO = null;
private static Factory instance = null;

public static synchronized Factory getInstance(){
    if (instance == null){
      instance = new Factory();
    }
    return instance;
}

public ElementDAO getElementDAO(){
    if (elementDAO == null){
    	elementDAO = new ElementDAOImpl();
    }
    return elementDAO;
}   
public FormDAO getFormDAO(){
    if (formDAO == null){
    	formDAO = new FormDAOImpl();
    }
    return formDAO;
} 

}

