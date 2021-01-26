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
		//val sandwichDeMila = ItemCarta("Mila de Carne",0,250, listOf("Tomate", "Lechuga", "Jamon"))
		//itemsRepository!!.save(sandwichDeMila)
	}

}

fun main(args: Array<String>) {
	runApplication<NickyapiApplication>(*args)
}
