package com.mycompany.myapp

class Product {

	String name
	String description
	Double price

    static constraints = {
    	description nullable: true
    	price nullable: false
    	name nullable: false, blank: false
    }
}
