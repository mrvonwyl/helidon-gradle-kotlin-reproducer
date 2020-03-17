package dev.elysion.mail.api


import javax.enterprise.context.RequestScoped
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/echo")
@RequestScoped
class EchoResource {

    @GET
    fun getHello(): String {
        return "Hello World"
    }
}