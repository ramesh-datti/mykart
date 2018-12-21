package com.mycompany.myapp

class Cart {

	User user

	static hasMany=[items:CartItem]

    static constraints = {
    	user nullable: false
    }
}
