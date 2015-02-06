package com.sl.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;



@Entity
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
@DynamicInsert(value=true)
@Table(name="element")
public class Element {
	
	private Integer id;
	private String name;
	private String type;
	private String nameVariable;
	private String value;
	private Set<Form> form = new HashSet<Form>();
//	
	public Element(){
		
	}
	
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")	
	public Integer getID(){
		return id;		
	}
	
	@Column(name="name")
	public String getName(){
		return name;
	}
	
	@Column(name="type")
	public String getType(){
		return type;
	}
	
	@Column(name="nameVariable")
	public String getNameVariable(){
		return nameVariable;
	}
	
	@Column(name="value")
	public String getValue(){
		return value;
	}
	
	
	
	
	
	public void setID(Integer id){
		this.id = id;
	}
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void setNameVariable(String nameVariable){
		this.nameVariable = nameVariable;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	



	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="element_in_form", joinColumns = {@JoinColumn(name = "element_ID")}, inverseJoinColumns = {@JoinColumn(name="form_ID")})
	public Set<Form> getForm() {
		return this.form;
	}



	public void setForm(Set<Form> form) {
		this.form = form;
	}	
	
	
	
	
//	

}
