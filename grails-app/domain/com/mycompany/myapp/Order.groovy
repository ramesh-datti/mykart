package com.mycompany.myapp

class Order {

	User user

	Double totalOrderPrice

	static hasMany=[items:OrderItem]

    static constraints = {
    	user nullable: false
    }
    static mapping = {
        table "myorders"
    }
}
