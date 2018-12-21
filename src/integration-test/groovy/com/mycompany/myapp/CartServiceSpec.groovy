package com.mycompany.myapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CartServiceSpec extends Specification {

    CartService cartService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Cart(...).save(flush: true, failOnError: true)
        //new Cart(...).save(flush: true, failOnError: true)
        //Cart cart = new Cart(...).save(flush: true, failOnError: true)
        //new Cart(...).save(flush: true, failOnError: true)
        //new Cart(...).save(flush: true, failOnError: true)
        assert true, "TODO: Provide a setupData() implementation for this generated test suite"
        //cart.id
    }

}
