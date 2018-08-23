package io.pivotal.workshop.activemq;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Company.class)
public class Company {
	private String name;
	private List<Product> products;
	
	public Company(){}

	public Company(String name){
		this.name = name;
	}
	
	public Company(String name, List<Product> products){
		this.name = name;
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
