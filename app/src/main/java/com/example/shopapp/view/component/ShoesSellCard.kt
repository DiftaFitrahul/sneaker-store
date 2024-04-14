package com.example.shopapp.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.R
import com.example.shopapp.ui.theme.Blue
import com.example.shopapp.ui.theme.DarkGrey


enum class CornerTypeComposableCard{
    Color,
    AddButton
}

@Composable
fun ShoesSellCard(
    modifier : Modifier = Modifier,
    cornerTypeComposableCard : CornerTypeComposableCard = CornerTypeComposableCard.AddButton,
    name: String = "",
    price: Double = 0.0,
    isFavoriteShoes: Boolean = false,
    onChangeFavorite: () -> Unit= {},
    onAddToCart : () -> Unit = {}
){

    val configuration = LocalConfiguration.current

    Box(modifier = modifier
        .width((configuration.screenWidthDp * 0.42).dp)
        .clip(RoundedCornerShape(14.dp))
        .background(color = Color.White)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp,
                    top = 10.dp,
                    bottom = if (cornerTypeComposableCard == CornerTypeComposableCard.Color) 10.dp else 0.dp
                )
        ) {
            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                       onChangeFavorite()
                    },
                imageVector = if(isFavoriteShoes) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                tint = if(isFavoriteShoes) Color.Red else Color.Black,
                contentDescription = "favorite"
            )
            Image(
                modifier = Modifier
                    .padding(end = 15.dp, top = 10.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .height(100.dp),
                painter = painterResource(id = R.drawable.nike1),
                contentDescription = "nike",
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(id = R.string.best_seller_text),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Blue,
                    fontSize = 12.sp
                )
            )
//            Spacer(modifier = Modifier.padding(top = 3.dp))
            Text(
                text = name,
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = DarkGrey,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = "$$price",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = DarkGrey,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .padding(
                            bottom = if (cornerTypeComposableCard == CornerTypeComposableCard.Color) 0.dp else 5.dp
                        )
                )



                if(cornerTypeComposableCard == CornerTypeComposableCard.Color)
                Row{
                    Box(modifier = Modifier

                        .clip(RoundedCornerShape(12.dp))
                        .size(15.dp)
                        .background(color = Color.Magenta)
                    )
                    Spacer(modifier = Modifier.width(9.dp))
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(15.dp)
                        .background(color = Color.Cyan)
                    )
                    Spacer(modifier = Modifier.width(10.dp))


                }
                else
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topStart = 14.dp))
                            .background(color = Blue)
                            .padding(vertical = 6.dp, horizontal = 6.dp)
                            .clickable { onAddToCart() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add to Cart",
                            tint = Color.White)
                    }
            }


        }
    }
}

@Preview
@Composable
fun CardComposable(){
    ShoesSellCard()
}