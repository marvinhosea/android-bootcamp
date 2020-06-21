package pro.marvinhosea.myprofile.controllers

import pro.marvinhosea.myprofile.models.Service

class ServiceController{
    val arrayOfServices: Array<Service> = arrayOf(
        Service("Painting", 600, "We paint houses, shops, vehicles and containers. There is art in our painting"),
        Service("Animal House Construction", 30000, "We are professional animal house constructors with twenty years of experience"),
        Service("Bookkeeping", 340000, "Are you struggling with bookkeeping? Then worry no more we're a team of accountants dedicated to keeping your books clean"),
        Service("Developer", 340000, "Developing quality software")
    )
    val services: MutableList<Service> = arrayOfServices.toMutableList()

    /**
     * Return single random service
     *
     * @Service
     */
    fun getSingleService(): Service {
        return services.random()
    }

    /**
     * Return all business services
     *
     * @MutableList<Service>
     */
    fun getAllServices(): MutableList<Service> {
        return services
    }

}