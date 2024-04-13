import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.Greeting
import com.example.shopapp.R
import com.example.shopapp.ui.theme.ShopAppTheme

@Composable
fun HomeTopBar(
    onDrawerClick:() -> Unit  = {},
    onShopNotificationClick: () -> Unit = {}
){
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
//            .background(color = Color.Red)
            .padding(horizontal = 16.dp, vertical = 10.dp)
            ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Image(painter = painterResource(id = R.drawable.hamburger),
            contentDescription = R.drawable.hamburger.toString(),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    onDrawerClick()
                }

            )
        Row(
            modifier = Modifier
                .wrapContentWidth()
        ) {
            Image(
                modifier = Modifier
                    .size(20.dp),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = R.drawable.highlight_text),
                contentDescription = R.drawable.highlight_text.toString())

            Text(
                text = stringResource(id = R.string.title_app_bar_home_screen),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp
                )
            )
        }

        Box(
            modifier = Modifier
                .size(43.dp)
                .clip(RoundedCornerShape(50.dp))
                .clickable {
                    onShopNotificationClick()
                }
                .background(Color.White)
                .padding(8.dp)
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .size(28.dp),
                imageVector = Icons.Filled.ShoppingBag,
                contentDescription = "Shopping chart",)
            Box(modifier = Modifier
                .offset(x = 18.dp, y = (-3).dp)
                .size(9.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color.Red)

            )
        }
    }
}

@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
            HomeTopBar()
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ShopAppTheme {
        HomeScreen()
    }
}