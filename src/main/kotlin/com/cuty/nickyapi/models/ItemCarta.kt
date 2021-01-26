package com.cuty.nickyapi.models

import javax.persistence.*

@Entity
@Table(name = "items")
class ItemCarta(
    @Column(length=5000)val nombreItemCarta : String,
    @Column val precio : Int,
    @Column val ingredientes : String,
    @Id  @GeneratedValue var id : Int
)
