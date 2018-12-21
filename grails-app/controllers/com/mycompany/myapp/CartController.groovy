package com.mycompany.myapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class CartController {

    CartService cartService

    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        def user = springSecurityService.currentUser

        respond cartService.list(params), model:[cartCount: cartService.count()]
    }

    def show(Long id) {

        def user = springSecurityService.currentUser

        def cart =  cartService.get(id)

        def total = cart?.items?.sum {it?.item?.price}

        respond cart, model:[user:user, total: total]
    }


    def addItemToCart() {

        User user=springSecurityService.currentUser

        Product item= Product.findById(params.id)

        Cart cart= Cart.findByUser(user)

        if(cart==null){
            cart = new Cart(user:user)
        }

        def cartItem = new CartItem()

        cartItem.item = item

        cartItem.cart = cart

        cart.addToItems(cartItem)

        cart.save(flush:true)

        redirect(action: "show", params:[id: cart.id])
    }

    def removeFromCart() {

        User user=springSecurityService.currentUser

        Product item= Product.findById(params.id)

        Cart cart= Cart.findByUser(user)

        CartItem cartItem = CartItem.findByCartAndItem(cart, item)

        cartItem.delete()

        cart.save(flush:true)

        redirect(action: "show", params:[id: cart.id])
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cart.label', default: 'Cart'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
