package com.mycompany.myapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class ProfileController {

    def springSecurityService

    def index(Integer max) {

        def user = springSecurityService.currentUser

        respond user
    }
}
