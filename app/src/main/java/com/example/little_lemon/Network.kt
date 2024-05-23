package com.example.little_lemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MenuNetworkData(@SerialName("menu") val menu: List<MenuItemNetwork>)

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: Int,
    @SerialName("image")
    val image: String,
    @SerialName("category")
    val category: String
){
fun toMenuItemRoom()  = MenuItemDatabase(
    id = id,
    title = title,
    price = price,
    description = description,
    image = image,
    category = category
)}