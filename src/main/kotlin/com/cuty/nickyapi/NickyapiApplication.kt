package com.cuty.nickyapi

import com.cuty.nickyapi.dao.ItemsRepository
import com.cuty.nickyapi.models.ItemCarta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication



@SpringBootApplication
class NickyapiApplication :CommandLineRunner{

	@Autowired
	val itemsRepository : ItemsRepository? = null

	override fun run(vararg args: String?) {
		val sandwichDeMila = ItemCarta(nombreItemCarta = "Mila de Carne",precio = 250, ingredientes = "Tomate/Lechuga/Jamon",id = 0, imagen = "https://image.shutterstock.com/image-photo/two-fresh-submarine-sandwiches-ham-260nw-497930494.jpg")
		itemsRepository!!.save(sandwichDeMila)
		val itemCarta = ItemCarta(imagen = "https://cdn.imageupload.workers.dev/mTd07heS_hamburguesa.jpg", nombreItemCarta = "Hamburguesa",precio = 310, ingredientes = "jamon/queso/lechuga/tomate", id = 0)
		itemsRepository!!.save(itemCarta)


	}

}

fun main(args: Array<String>) {
	runApplication<NickyapiApplication>(*args)
}
