package com.cuty.nickyapi.web

import com.cuty.nickyapi.business.NItemBusiness
import com.cuty.nickyapi.exceptions.BusinessException
import com.cuty.nickyapi.models.ItemCarta
import com.cuty.nickyapi.utils.Constantes
import com.robchoco.demo.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(Constantes.URL_BASE_ITEMSCARTA)
class ItemsRestController {
    @Autowired
    val itemsBusiness: NItemBusiness? = null

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
        }catch (e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }


}