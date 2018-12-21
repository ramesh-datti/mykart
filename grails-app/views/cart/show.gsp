<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cart.label', default: 'Cart')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-cart" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" controller="product" action="index">Continue Shopping</g:link></li>
            </ul>
        </div>
        <div id="show-cart" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <table>
                <thead>
                <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th></th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${cart.items}" var="item" status="i">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                <td>${item.item.name}</td>
                                <td>${item.item.price}</td>
                                  <td><g:link controller="cart" action="removeFromCart" params="[id:item.item.id]">Remove</g:link> </td>
                               
                    </tr>
                </g:each>
                <tr>
                       <td colspan="2">
                               Total
                        </td>
                        <td>
                               ${total}
                        </td>
                </tr>
                </tbody>
            </table>


    <div class="nav" role="navigation">
            <ul>
                <li><g:link controller="order" action="placeOrder" class="order" params="[id:cart.id]">Order</a></g:link>

            </ul>
        </div>





        </div>
    </body>
</html>
