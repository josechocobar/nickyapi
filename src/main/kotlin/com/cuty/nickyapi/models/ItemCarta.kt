package com.cuty.nickyapi.models

import javax.persistence.*

@Entity
@Table(name = "items")
class ItemCarta(
    @Column(length=5000)val nombreItemCarta : String,
    @Column val precio : Int,
    @Column (length=5000)val ingredientes : String,
    @Column(length=1500)var imagen : String,
    @Id  @GeneratedValue var id : Int
)
