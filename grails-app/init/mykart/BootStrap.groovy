package mykart
import com.mycompany.myapp.Role
import com.mycompany.myapp.UserRole
import com.mycompany.myapp.User

import com.mycompany.myapp.Product

class BootStrap {

    def init = { servletContext ->

  		 def adminRole = new Role(authority: 'ROLE_ADMIN').save()

  		 def userRole = new Role(authority: 'ROLE_USER').save()

         def adminUser = new User(username: 'admin', password: 'admin').save()
         def testUser1 = new User(username: 'demo', password: 'demo').save()
         def testUser2 = new User(username: 'demo2', password: 'demo2').save()

         UserRole.create adminUser, adminRole
         UserRole.create testUser1, userRole
         UserRole.create testUser2, userRole

         UserRole.withSession {
            it.flush()
            it.clear()
         }


         new Product(name:'iPhone7',description:'new iPhone 7 with latest features',price: 300).save()

         new Product(name:'Pixel',description:'new Pixel mobile from Google',price: 350).save()


         assert User.count() == 3
         assert Role.count() == 2
         assert UserRole.count() == 3

    }
    def destroy = {
    }



}
