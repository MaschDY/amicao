package br.com.maschdy.amicao.ui.screen.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.maschdy.amicao.R
import br.com.maschdy.amicao.data.model.Buddy
import br.com.maschdy.amicao.ui.theme.AmicaoTheme

class DetailActivity : ComponentActivity() {
    private val buddy by lazy {
        intent.getSerializableExtra(BUDDY_ID) as Buddy
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmicaoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen(buddy)
                }
            }
        }
    }

    @Composable
    fun ProfileScreen(buddy: Buddy) {
        val scrollState = rememberScrollState()

        Column(modifier = Modifier.fillMaxSize()) {
            BoxWithConstraints {
                Surface {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState),
                    ) {
                        ProfileHeader(
                            buddy,
                            this@BoxWithConstraints.maxHeight
                        )
                        ProfileContent(buddy, this@BoxWithConstraints.maxHeight)
                    }
                }
            }
        }
    }

    @Composable
    private fun ProfileHeader(
        buddy: Buddy,
        containerHeight: Dp
    ) {
        Image(
            modifier = Modifier
                .heightIn(max = containerHeight / 2)
                .fillMaxWidth(),
            painter = painterResource(id = buddy.buddyImageId),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }

    @Composable
    private fun ProfileContent(buddy: Buddy, containerHeight: Dp) {
        Column {
            Spacer(modifier = Modifier.height(8.dp))

            ProfileTitle(buddy)

            ProfileProperty(stringResource(R.string.sex), buddy.sex)
            ProfileProperty(stringResource(R.string.age), buddy.age.toString())
            ProfileProperty(stringResource(R.string.personality), buddy.description)

//            Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
        }
    }

    @Composable
    fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
        Column(modifier = Modifier.padding(16.dp)) {
            Divider()
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = label,
                    modifier = Modifier.requiredHeight(24.dp),
                    overflow = TextOverflow.Visible,
                    style = MaterialTheme.typography.caption,
                )
            }
            val style = if (isLink) {
                MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
            } else {
                MaterialTheme.typography.body1
            }
            Text(
                text = value,
                modifier = Modifier.requiredHeight(24.dp),
                overflow = TextOverflow.Visible,
                style = style
            )
        }
    }

    @Composable
    private fun ProfileTitle(
        buddy: Buddy
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = buddy.name,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
        }
    }

    companion object {
        private const val BUDDY_ID = "buddy_id"
        fun newIntent(context: Context, buddy: Buddy) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(BUDDY_ID, buddy)
            }
    }
}