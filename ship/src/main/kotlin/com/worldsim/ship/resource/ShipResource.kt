package com.worldsim.ship.resource

import com.codahale.metrics.annotation.Timed
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/ship")
@Produces(MediaType.APPLICATION_JSON)
class ShipResource() {

    @Timed
    @GET
    fun greeting(@QueryParam("name") name : Optional<String>) : Saying = Saying(name.orElse("Nigel"))
}

data class Saying(val format: String)
