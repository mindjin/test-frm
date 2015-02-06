package com.sl.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="form")
public class Form {
	private Integer id;
	private String name;
	private Set<Element> element = new HashSet<Element>();
	public Form(){
		
	}
	
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	public Integer getId(){
		return id;
		
	}
	@Column(name="name")
	public String getName(){
		return name;
		
	}
	
	public void setId(Integer id){
		this.id = id;
	}
		
	public void setName(String name){
		this.name = name;
	}



	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="element_in_form", joinColumns = {@JoinColumn(name = "form_ID")}, inverseJoinColumns = {@JoinColumn(name="element_ID")})
	public Set <Element>  getElement() {
		return this.element;
	}



	public void setElement(Set <Element> element) {
		this.element = element;
	}	
	
	
	
	

	
}
