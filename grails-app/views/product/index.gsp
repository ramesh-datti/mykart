<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

                <li>
                    <g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
                   
                </li>

                <g:if test="${cart}">
                <li>
                    <g:link controller="cart" action="show" params="[id:cart?.id]">My Cart</g:link>
                   
                </li>
                </g:if>

            </ul>
        </div>



        <div id="list-item" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Cart</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${productList}" var="item" status="i">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                <td>${item.name}</td>
                                <td>${item.price}</td>
                                <g:if test="${!cart || !cart?.items?.item?.id.contains(item.id)}">
                                  <td><g:link controller="cart" action="addItemToCart" params="[id:item.id]">Add</g:link> </td>
                                </g:if>
                                <g:else>
                                  <td><g:link controller="cart" action="removeFromCart" params="[id:item.id]">Remove</g:link> </td>

                                </g:else>
                    </tr>
                </g:each>
                </tbody>
            </table>

            <div class="pagination">
                <g:paginate total="${itemCount ?: 0}" />
            </div>
        </div>


    </body>
</html>