package com.cuty.nickyapi.business

import com.cuty.nickyapi.dao.ItemsRepository
import com.cuty.nickyapi.exceptions.BusinessException
import com.cuty.nickyapi.models.ItemCarta
import com.cuty.nickyapi.exceptions.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class NItemBusiness : ItemsBusiness {

    @Autowired
    val itemsRepository : ItemsRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<ItemCarta> {
        try {
            return itemsRepository!!.findAll()
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idItem: Int): ItemCarta {
        val op: Optional<ItemCarta>
        try {
            op = itemsRepository!!.findById(idItem)
        }catch (e:Exception){
            throw BusinessException("No")
        }
        if (!op.isPresent){
            throw NotFoundException("Not Found")
        }
        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(itemCarta: ItemCarta): ItemCarta {
        try {
            return itemsRepository!!.save(itemCarta)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idItem: Int) {
        val op:Optional<ItemCarta>
        try {
            op = itemsRepository!!.findById(idItem)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if (!op.isPresent){
            throw NotFoundException("Not Found id = $idItem")
        }else{
            try {
                itemsRepository!!.deleteById(idItem)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }
}