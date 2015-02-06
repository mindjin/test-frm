package com.sl.data;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.hibernate.Session;

public class FormDAOImpl implements FormDAO {
	 
	public void addForm(Form form) throws SQLException {
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(form);
			session.getTransaction().commit();;
		}catch(Exception e){
			 JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
			
		}
		finally{
			if(session !=null && session.isOpen()){
				
				session.close();
				 
		}
		// TODO Auto-generated method stub
		
	}
		
	}
	}
