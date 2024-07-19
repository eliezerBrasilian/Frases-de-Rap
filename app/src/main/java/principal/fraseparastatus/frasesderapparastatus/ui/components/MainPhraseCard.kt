package principal.fraseparastatus.frasesderapparastatus.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import principal.fraseparastatus.frasesderapparastatus.data.getRandomPhrase
import principal.fraseparastatus.frasesderapparastatus.ui.theme.Purple40

@Composable
fun MainPhraseCard(){
    val randomPhrase by remember{mutableStateOf(getRandomPhrase())}

    Card(onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(Purple40),
        modifier = Modifier.padding(horizontal = 20.dp)) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = randomPhrase.phrase, color = Color.White)
            Text(text = randomPhrase.singer,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White, textAlign = TextAlign.Center)
        }
    }
}