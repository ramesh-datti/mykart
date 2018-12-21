package com.mycompany.myapp

class OrderItem {

	Order order

	Product item

	Integer count

	Double itemPrice

	Double totalPrice

    static constraints = {
    	order nullable: false
    	item nullable: false
    	count nullable: false
		itemPrice nullable: false
		totalPrice nullable: false
    }
}
