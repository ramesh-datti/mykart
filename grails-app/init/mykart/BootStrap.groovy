package mykart
import com.mycompany.myapp.Role
import com.mycompany.myapp.UserRole
import com.mycompany.myapp.User

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

         assert User.count() == 3
         assert Role.count() == 2
         assert UserRole.count() == 3

    }
    def destroy = {
    }



}
