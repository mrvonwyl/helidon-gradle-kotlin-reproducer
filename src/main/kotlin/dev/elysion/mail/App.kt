package dev.elysion.mail

import io.helidon.config.Config
import io.helidon.config.ConfigSources.classpath
import io.helidon.config.ConfigSources.file
import io.helidon.config.PollingStrategies
import io.helidon.microprofile.server.Server

fun main(args: Array<String>) {
    // redirect JUL logs to Log4j. This statement needs to be before any logging calls
    System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager")
    System.setProperty("log4j.configurationFile", "config/logging.yaml")

    val server = Server.builder().config(buildConfig()).build().start()

    println("http://localhost:" + server.port() + "/echo");
}

fun buildConfig(): Config {
    return Config.builder().sources(
        file("config/application.yaml").pollingStrategy(PollingStrategies::watch).optional(),
        classpath("META-INF/microprofile-config.properties").optional(),
        classpath("application.yaml")
    ).build()
}