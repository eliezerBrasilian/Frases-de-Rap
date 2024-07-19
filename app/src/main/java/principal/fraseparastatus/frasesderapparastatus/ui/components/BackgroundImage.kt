package principal.fraseparastatus.frasesderapparastatus.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import principal.fraseparastatus.frasesderapparastatus.R
import principal.fraseparastatus.frasesderapparastatus.data.Phrase
import principal.fraseparastatus.frasesderapparastatus.data.phrases
import java.util.Random

@Composable
fun BackgroundImage(children:@Composable ()->Unit){
    val bgImages = listOf(R.drawable.unsplash_1, R.drawable.unsplash_2, R.drawable.unsplash_3,
        R.drawable.unsplash_4
            )
    val image by remember{ mutableIntStateOf(bgImages.random()) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
        )
        children()
    }
}