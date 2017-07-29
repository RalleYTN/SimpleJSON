package test;

import java.util.Date;

import de.ralleytn.simple.json.JSONAttribute;
import de.ralleytn.simple.json.JSONRoot;

@JSONRoot
public class Product {

	@JSONAttribute(name = "price")
	public float price;
	
	@JSONAttribute(name = "name")
	public String name;
	
	@JSONAttribute(name = "stock")
	public int stock;
	
	@JSONAttribute(name = "next")
	public Product next;
	
	@JSONAttribute(name = "date")
	public Date date = new Date();
}
