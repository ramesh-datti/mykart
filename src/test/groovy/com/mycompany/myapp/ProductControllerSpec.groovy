package com.mycompany.myapp

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import grails.validation.ValidationException
import spock.lang.*


class ProductControllerSpec extends Specification implements ControllerUnitTest<ProductController>, DomainUnitTest<Product> {


    Class<?>[] getDomainClassesToMock(){
        return [User,Role,Cart, CartItem] as Class[]
    }

    void "Test the index action returns the correct model"() {
        given:
        controller.productService = Mock(ProductService) {

            1 * list(_) >> []
            1 * count() >> 0
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        !model.productList
        model.itemCount == 0
    }


    void "Test the create action returns the correct model"() {

        given:
            params.name='testProduct'
            params.description='this is a test product'

        when:"The create action is executed"
        controller.create()

        then:"The model is correctly created"
        model.product!= null
    }

 
}






