import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mywishlistapp.AppBarView
import com.example.mywishlistapp.data.DummyWish
import com.example.mywishlistapp.data.Wish

@Composable
fun HomeView() {
    Scaffold(
        topBar = {AppBarView(title = "WishList") {
                val context = LocalContext.current
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
            }},
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all= 20.dp,
                    contentColor = Color.White,
                    backgroundColor = Color.Black,
                    onClick = {
                        Toast.makeText(context, Text="FAB Button Clicked", Toast.LENGTH_LONG).show()
                    }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }fun ge

        }

    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            items(DummyWish.wishList){
                wish -> WishItem(wish = wish) {

            }
            }
        }
    }
}

@Composable

fun WishItem(wish: Wish, onClick:() -> Unit){
    Card(modifier = Modifier.fillMaxSize()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable{
            onClick()
        },
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
    }
}
