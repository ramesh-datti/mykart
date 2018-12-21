package com.mycompany.myapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProductServiceSpec extends Specification {

    ProductService productService
    SessionFactory sessionFactory

    private Long setupData() {
        def product = new Product(name:'redme1',description:'this is redme phone').save(flush: true, failOnError: true)
        new Product(name:'samsung',description:'this is Samsung phone').save(flush: true, failOnError: true)
        assert true, "TODO: Provide a setupData() implementation for this generated test suite"
        product.id
    }

    
}
