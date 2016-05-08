package com.worldsim.ship

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.worldsim.ship.config.ShipConfig
import com.worldsim.ship.resource.ShipResource
import io.dropwizard.Application
import io.dropwizard.assets.AssetsBundle
import io.dropwizard.java8.Java8Bundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class ShipService : Application<ShipConfig>() {
    override fun run(configuration: ShipConfig, environment: Environment) {
        environment.jersey().register(ShipResource())
    }

    override fun initialize(bootstrap: Bootstrap<ShipConfig>) {
        bootstrap.apply {
            addBundle(Java8Bundle())
            addBundle(AssetsBundle("/assets", "/", "/index.html"))
            objectMapper.apply {
                registerModule(KotlinModule())
            }
        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ShipService().run(*args)
        }
    }

}