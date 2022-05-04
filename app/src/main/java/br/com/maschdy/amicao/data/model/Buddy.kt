package br.com.maschdy.amicao.data.model

import java.io.Serializable

data class Buddy(
    val id: Int,
    val name: String,
    val sex: String,
    val age: Int,
    val description: String,
    val buddyImageId: Int = 0
) : Serializable
