package com.cuty.nickyapi.web

import com.cuty.nickyapi.business.ItemsBusiness
import com.cuty.nickyapi.exceptions.BusinessException
import com.cuty.nickyapi.models.ItemCarta
import com.cuty.nickyapi.utils.Constantes
import com.cuty.nickyapi.exceptions.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constantes.URL_BASE_ITEMSCARTA)
class ItemsRestController {
    @Autowired
    val itemsBusiness: ItemsBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<ItemCarta>>{
        return try {
            ResponseEntity(itemsBusiness?.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idItemCarta: Int): ResponseEntity<ItemCarta>{
        return try {
            ResponseEntity(itemsBusiness?.load(idItemCarta), HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody itemCarta: ItemCarta): ResponseEntity<ItemCarta>{
        return try {
            itemsBusiness?.save(itemCarta)
            val responseHeader = HttpHeaders()
            responseHeader.set("Location", Constantes.URL_BASE_ITEMSCARTA+"/"+itemCarta.id)
            ResponseEntity(responseHeader,HttpStatus.CREATED)

        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @PutMapping("")
    fun update(@RequestBody itemCarta: ItemCarta) : ResponseEntity<ItemCarta> {
        return try {
            itemsBusiness?.save(itemCarta)
            ResponseEntity(HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }




}