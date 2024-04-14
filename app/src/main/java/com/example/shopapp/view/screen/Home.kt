import android.os.Build.VERSION_CODES.Q
import android.util.Log
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.Greeting
import com.example.shopapp.R
import com.example.shopapp.ui.theme.Blue
import com.example.shopapp.ui.theme.ShopAppTheme
import com.example.shopapp.view.component.DefaultAppTextField

@Composable
fun HomeTopBar(
    onDrawerClick:() -> Unit  = {},
    onShopNotificationClick: () -> Unit = {}
){
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
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
                imageVector = Icons.Default.ShoppingCart,
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

@RequiresApi(Q)
@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
            HomeTopBar()
        },
        containerColor = Color.Gray.copy(alpha = 0.035f)
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
        SearchBarShoes(
            value = "",
            onValueChange = {

            },
            onDone = {

            }
        )
            CategorySection(
                onCategorySelected = {
                Log.d("Selected Category", it)
                }
            )
        }
    }
}

@RequiresApi(Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarShoes(
    value: String,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit
){
    DefaultAppTextField(
        modifier = Modifier
            .fillMaxWidth()
            .advancedShadow(
                shadowBlurRadius = 6.dp,
                cornersRadius = 14.dp,
                offsetY = 3.dp,
                alpha = 0.1f

            ),
        keyboardActions = KeyboardActions (onDone = {
            onDone()
        }),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        value = "",
        onValueChange = onValueChange,
        leadingIcon = {
                      Icon(imageVector = Icons.Filled.Search, contentDescription = "Search_bar")
        },
        placeHolder = stringResource(id = R.string.placeholder_search_bar_home_screen),
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White
        )
}

@Composable
fun CategorySection(
    onCategorySelected: (String) -> Unit
){

    val listCategory = arrayOf(
        stringResource(id = R.string.select_all_category_home_screen),
        stringResource(id = R.string.select_outdoor_category_home_screen),
        stringResource(id = R.string.select_tennis_category_home_screen)
        )

    var selectedCategory by remember{ mutableStateOf(listCategory.first()) }

    Column(
        modifier = Modifier.wrapContentHeight()
    ) {
        Text(
            modifier = Modifier.padding(top = 21.dp, bottom = 13.dp),
            text = stringResource(id = R.string.select_category_home_screen),
            style = MaterialTheme.typography.headlineSmall.copy(
            fontSize = 16.sp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listCategory.map { Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background( if(selectedCategory == it) Blue else Color.White)
                    .padding(vertical = 10.dp)
                    .width(110.dp)
                    .clickable {
                        selectedCategory = it
                        onCategorySelected(it)
                    }
                ,
            contentAlignment = Alignment.Center
            ) {
                Text(text = it, style = MaterialTheme.typography.bodyMedium.copy(
                    color = if(selectedCategory == it) Color.White else Color.Black
                ))
            } }
        }
    }
}

@RequiresApi(Q)
fun Modifier.advancedShadow(
    color: Color = Color.Black,
    alpha: Float = 1f,
    cornersRadius: Dp = 0.dp,
    shadowBlurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = drawBehind {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparentColor = color.copy(alpha = 0f).toArgb()

    drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowBlurRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            cornersRadius.toPx(),
            cornersRadius.toPx(),
            paint
        )
    }
}
@RequiresApi(Q)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ShopAppTheme {
        HomeScreen()
    }
}