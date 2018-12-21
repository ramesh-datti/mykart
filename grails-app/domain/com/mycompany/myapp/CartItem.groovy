package com.mycompany.myapp

class CartItem {

	Cart cart

	Product item

	Integer count = 1

    static constraints = {
    	cart nullable: false
    	item nullable: false
    	count nullable: false
    }
}
