package com.worldsim.ship

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.worldsim.ship.config.ShipConfig
import com.worldsim.ship.resource.ShipResource
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class ShipService : Application<ShipConfig>() {
    override fun run(configuration: ShipConfig, environment: Environment) {
        environment.jersey().register(ShipResource())
    }

    override fun initialize(bootstrap: Bootstrap<ShipConfig>) {
        bootstrap.objectMapper.registerModule(KotlinModule())
        bootstrap.objectMapper.registerModule(Jdk8Module())
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ShipService().run(*args)
        }
    }

}
