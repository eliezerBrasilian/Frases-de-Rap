package principal.fraseparastatus.frasesderapparastatus.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ExpandAlt

@Composable
fun ColapseListRowText(onClick:()->Unit) {

    Row(horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.ExpandAlt, contentDescription = "Menu",
            modifier = Modifier.size(14.dp)
        )
        Text(text = "Estreitar lista", fontSize = 12.sp)
    }
}