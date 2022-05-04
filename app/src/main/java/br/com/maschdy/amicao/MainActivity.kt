package br.com.maschdy.amicao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.maschdy.amicao.data.DataProvider
import br.com.maschdy.amicao.data.model.Buddy
import br.com.maschdy.amicao.ui.screen.detail.DetailActivity
import br.com.maschdy.amicao.ui.theme.AmicaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmicaoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen {
                        startActivity(DetailActivity.newIntent(this, it))
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navigateToDetail: (Buddy) -> Unit) {
    val buddies = remember { DataProvider.buddyList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp)
    ) {
        items(buddies) { buddy ->
            BuddyListItem(buddy, navigateToDetail)
        }
    }
}

@Composable
fun BuddyListItem(buddy: Buddy, navigateToDetail: (Buddy) -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(18.dp))
    ) {
        Row(
            modifier = Modifier
                .clickable { navigateToDetail(buddy) }
        ) {
            BuddyImage(buddy)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = buddy.name, style = typography.h6)
                Text(text = "VIEW DETAIL", style = typography.caption)
            }
        }
    }
}

@Composable
private fun BuddyImage(buddy: Buddy) {
    Image(
        painter = painterResource(id = buddy.buddyImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Preview(name = "Light Mode", showBackground = true)
//@Preview(
//    name = "Dark Mode",
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true
//)
@Composable
fun DefaultPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        HomeScreen {
            println("Navigate Detail Screen")
        }
    }
}