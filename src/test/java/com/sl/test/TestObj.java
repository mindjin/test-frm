package com.sl.test;

public class TestObj extends TestObj2{
	
	private int i;

	public TestObj(int i){
		this.i = i;
		insideTab(i);
	}

	public TestObj setLocation(String value){
		System.out.println(i+value);
		return this;
	}
	
	public TestObj setname(String value){
		System.out.println(i+value);
		return this;
	}
}
