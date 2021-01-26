package com.cuty.nickyapi.dao

import com.cuty.nickyapi.models.ItemCarta
import org.springframework.data.jpa.repository.JpaRepository

interface ItemsRepository : JpaRepository<ItemCarta, Int> {
}