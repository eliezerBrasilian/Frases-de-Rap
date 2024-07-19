package principal.fraseparastatus.frasesderapparastatus.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Search

@Composable
fun SearchBarComponent(query: String, onQueryChange: (String) -> Unit) {
    TextField(
        value = query, onValueChange = onQueryChange,
        leadingIcon = {
            Icon(
                imageVector = FontAwesomeIcons.Solid.Search,
                contentDescription = null,
                modifier = Modifier.size(10.dp)
            )
        },
        placeholder = { Text(text = "Pesquisar frase", fontSize = 15.sp) },
        modifier = Modifier.fillMaxWidth()
    )
}