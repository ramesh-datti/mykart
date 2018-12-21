<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>My Profile</title>
    </head>
    <body>
    
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

                <li><g:link class="order" controller="order" action="index">My Orders</g:link></li>

                <li><g:link class="cart" controller="cart" action="index">My Cart</g:link></li>
            </ul>
        </div>


        <div>

            <div class="card">
                    <img src="/assets/grails.svg" alt="John" style="width:100px">
                    <h1>Name: ${user.username}</h1>
                    <p></p>
                    
            </div>
        </div>


    </body>
</html>