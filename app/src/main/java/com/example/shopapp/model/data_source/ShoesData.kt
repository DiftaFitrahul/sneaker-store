package com.example.shopapp.model.data_source

import androidx.compose.ui.res.painterResource
import com.example.shopapp.R
import com.example.shopapp.model.entity.Shoes

object ShoesData{
     val listData = listOf<Shoes>(
         Shoes(
             shoesImage =  R.drawable.nike0,
             name = "Nike Jordan",
             price = 725.00,
         ),
         Shoes(
             shoesImage =  R.drawable.nike1,
             name = "Nike Air Max",
             price = 305.00
         ),
         Shoes(
             shoesImage =  R.drawable.nike2,
             name = "Nike Dunk",
             price = 675.00
         ),Shoes(
             shoesImage =  R.drawable.nike3,
             name = "Nike Roshe Run",
             price = 820.10
         ),
         Shoes(
             shoesImage =  R.drawable.nike4,
             name = "Nike Air Force 1",
             price = 495.00
         ),
         Shoes(
             shoesImage =  R.drawable.nike5,
             name = "Nike Blazer",
             price = 662.60
         ),
         Shoes(
             shoesImage =  R.drawable.nike6,
             name = "Nike Cortez",
             price = 512.30
         ),
         Shoes(
             shoesImage =  R.drawable.nike7,
             name = "Nike Zoom Pegasus",
             price = 925.99
         ),
         Shoes(
             shoesImage =  R.drawable.nike8,
             name = "Nike React Element",
             price = 651.00
         ),
         Shoes(
             shoesImage =  R.drawable.nike9,
             name = "Nike VaporMax",
             price = 771.71
         ),

     )
}