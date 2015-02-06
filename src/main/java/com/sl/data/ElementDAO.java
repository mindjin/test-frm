package com.sl.data;

import java.sql.SQLException;
import java.util.List;

public interface ElementDAO {
	
	public List<Element> getAllField(String nameClass) throws SQLException;
	
	public void updateField(int id, String value) throws SQLException;
	
	public void addField(Element element) throws SQLException;
	
	public String getSearchItem(String nameField);

}
