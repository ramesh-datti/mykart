<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cart.label', default: 'Cart')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-cart" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
        <div id="list-cart" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>

            <table>
                <thead>
                <tr>
                        <th>Name</th>
                        <th>Price</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${cart?.items}" var="item" status="i">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                <td>${item.item.name}</td>
                                <td>${item.item.price}</td>
                                  <td><g:link controller="cart" action="removeFromCart" params="[id:item.item.id]">Remove from Cart</g:link> </td>
                               
                    </tr>
                </g:each>
                </tbody>
            </table>

            <f:table collection="${cartList}" />

            <div class="pagination">
                <g:paginate total="${cartCount ?: 0}" />
            </div>
        </div>
    </body>
</html>