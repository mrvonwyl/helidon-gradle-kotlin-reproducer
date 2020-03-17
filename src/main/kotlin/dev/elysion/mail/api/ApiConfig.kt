package dev.elysion.mail.api

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/api")
class ApiConfig : Application() {
    override fun getSingletons(): MutableSet<Any> {
        println(" ------ register jersey ------")
        return mutableSetOf(EchoResource())
    }
}