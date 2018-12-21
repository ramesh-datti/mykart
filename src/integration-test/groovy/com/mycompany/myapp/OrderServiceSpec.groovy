package com.mycompany.myapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OrderServiceSpec extends Specification {

    OrderService orderService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Order(...).save(flush: true, failOnError: true)
        //new Order(...).save(flush: true, failOnError: true)
        //Order order = new Order(...).save(flush: true, failOnError: true)
        //new Order(...).save(flush: true, failOnError: true)
        //new Order(...).save(flush: true, failOnError: true)
        assert true, "TODO: Provide a setupData() implementation for this generated test suite"
        //order.id
    }

    
}
