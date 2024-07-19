package principal.fraseparastatus.frasesderapparastatus.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Crown

@Composable
fun TitleWithCrown() {
    Row() {
        Icon(
            imageVector = FontAwesomeIcons.Solid.Crown, contentDescription = "Menu",
            modifier = Modifier.size(20.dp)
        )
        Text(text = "Frases de Rap", fontSize = 19.sp)
    }
}