package com.cuty.nickyapi.business

import com.cuty.nickyapi.models.ItemCarta

interface ItemsBusiness {
    fun list():List<ItemCarta>
    fun load(idItem : Int): ItemCarta
    fun save(itemCarta: ItemCarta):ItemCarta
    fun remove(idItem: Int)
}