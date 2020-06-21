package pro.marvinhosea.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import pro.marvinhosea.myprofile.controllers.ServiceController
import pro.marvinhosea.myprofile.models.Service

class MainActivity : AppCompatActivity() {

    val serviceController = ServiceController()

    internal lateinit var showNextServiceButton: Button
    internal lateinit var serviceNameView: TextView
    internal lateinit var serviceDescriptionView: TextView
    internal lateinit var servicePriceView: TextView
    internal lateinit var totalService: TextView
    internal lateinit var service: Service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNextServiceButton = findViewById(R.id.showNextServiceButton)
        serviceNameView = findViewById(R.id.serviceName)
        serviceDescriptionView = findViewById(R.id.serviceDescription)
        servicePriceView = findViewById(R.id.servicePrice)
        totalService = findViewById(R.id.numberOfService)

        serviceNameView.text = getString(R.string.serviceName, "")
        serviceDescriptionView.text = getString(R.string.serviceDescription, "")
        servicePriceView.text = getString(R.string.servicePrice, 0)
        totalService.text = getString(R.string.numberOfService, getAllService().count())

        //Listen to show next service button click
        showNextServiceButton.setOnClickListener { view ->
            displayServiceDetail()
        }
    }

    /**
     * Get all business services
     */
    private fun getAllService(): MutableList<Service> {
        return serviceController.getAllServices();
    }

    /**
     * This method display the selected random business service
     */
    private fun displayServiceDetail() {

        service = getRandomService()

        serviceNameView.text = getString(R.string.serviceName, service.name)
        serviceDescriptionView.text = getString(R.string.serviceDescription, service.description)
        servicePriceView.text = getString(R.string.servicePrice, service.price)
    }

    /**
     * Select a random service from business services
     */
    private fun getRandomService(): Service {
        return serviceController.getSingleService()
    }
}