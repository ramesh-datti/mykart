package com.mycompany.myapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class OrderController {

    OrderService orderService
    CartService cartService

    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond orderService.list(params), model:[orderCount: orderService.count()]
    }

    def show(Long id) {
        respond orderService.get(id)
    }

    def create() {
        respond new Order(params)
    }

    def placeOrder() {
        def user = springSecurityService.currentUser

        def cart =  cartService.get(params.id)

        def order = new Order()

        order.user = user

        def totalOrderPrice = 0

        if (!cart || !cart?.items || cart?.items?.size() == 0) {
            flash.message = "Your Cart is empty, nothing to order"
            redirect(url:'/order/index')
            return
        }

        cart?.items?.each {
            cartItem  ->
                def orderItem = new OrderItem()
                orderItem.item = cartItem.item
                orderItem.count = cartItem.count
                orderItem.itemPrice = cartItem.item.price

                orderItem.totalPrice = cartItem.count * cartItem.item.price
                totalOrderPrice += orderItem.totalPrice
                order.addToItems(orderItem)
                cartItem.delete()
        }

        order.totalOrderPrice = totalOrderPrice

        order.save()

        if (cart) {
            cartService.delete(cart.id)
        }

        flash.message = "Order create successfully, new Order Id: " + order.id

        redirect(url:'/order/index')


    }




    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
