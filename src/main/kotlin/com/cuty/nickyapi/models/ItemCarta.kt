package com.cuty.nickyapi.models

import javax.persistence.*

@Entity
@Table(name = "items")
data class ItemCarta(
    @Column(length=5000)val nombreItemCarta : String,
    @Id  @GeneratedValue var id : Int = 1,
    @Column val precio : Int,
    @Column val ingredientes : List<String>
)
