package com.sl.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ElementDAOImpl implements ElementDAO {

	public List<Element> getAllField(String nameClass) throws SQLException {
		Session session = null;
		
		List<Element> elements = new ArrayList<Element>();
		try{
			
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			elements = session.createCriteria(Element.class).createAlias("form", "form").add(Restrictions.like("form.name", nameClass)).list();
			
			//banners = (List<Banners>)session.createCriteria(Banners.class).list();
		}catch(Exception e){
			 JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
		}finally{
			if(session !=null && session.isOpen()){
				
				session.close();
				 
				
			}
		}
		
		return elements;
	}
	
	public String getSearchItem(String nameField){
		Session session = null;
		String value = null;
		List<Element> elements = new ArrayList<Element>();
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			
			elements = session.createCriteria(Element.class).list();
			
			for(Element el : elements){
				if(el.getNameVariable().equals(nameField)){
					value = el.getValue();
					return value;
				
				}
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
		}finally{
			if(session !=null && session.isOpen()){
				
				session.close();
			
				 
			}
		
		}
		
		return value;
		
		
	}

	public void updateField(int id, String value) throws SQLException {
		
		Session session = null;
		Element element = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			element =(Element) session.load(Element.class, id);
			element.setValue(value);
			
			session.update(element);
			
			
//			session.saveOrUpdate("value", element);
			session.getTransaction().commit();
//			banners = (List<Banners>)session.createCriteria(Banners.class).list();
		}catch(Exception e){
			 JOptionPane.showMessageDialog(null, e.getMessage()+" "+e.getCause(), "Error I/O", JOptionPane.OK_OPTION);
		}finally{
			
			if(session !=null && session.isOpen()){
				session.close();
				
				 
			}
		}
		
	
	}
	
public void addField(Element element) throws SQLException {
		
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(element);
			
			
//			session.saveOrUpdate("value", element);
			session.getTransaction().commit();
//			banners = (List<Banners>)session.createCriteria(Banners.class).list();
		}catch(Exception e){
			 JOptionPane.showMessageDialog(null, e.getMessage()+" "+e.getCause(), "Error I/O", JOptionPane.OK_OPTION);
		}finally{
			
			if(session !=null && session.isOpen()){
				session.close();
				 
				
			}
		}
		
	
	}

	
	

}
