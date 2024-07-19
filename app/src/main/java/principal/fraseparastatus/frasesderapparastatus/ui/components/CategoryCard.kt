package principal.fraseparastatus.frasesderapparastatus.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import principal.fraseparastatus.frasesderapparastatus.R
import principal.fraseparastatus.frasesderapparastatus.data.CategoryData

@Composable
fun CategoryCard(categoryData: CategoryData, onClick:()->Unit = {}) {
        Image(
            painter = painterResource(id = categoryData.imageResource),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .border(1.dp, Color.White, CircleShape)
                .clickable(onClick = onClick)
        )
}

@Preview
@Composable
fun CategoryCardPreview() {
    Image(
        painter = painterResource(id = R.drawable.rap),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .border(1.dp, Color.White, CircleShape)
    )
}