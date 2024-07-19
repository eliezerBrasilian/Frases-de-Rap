package principal.fraseparastatus.frasesderapparastatus.ui.components

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.Copy
import compose.icons.fontawesomeicons.solid.ShareAltSquare
import principal.fraseparastatus.frasesderapparastatus.data.Phrase
import principal.fraseparastatus.frasesderapparastatus.data.getRandomPhrase
import principal.fraseparastatus.frasesderapparastatus.data.showInterstitial
import principal.fraseparastatus.frasesderapparastatus.ui.theme.Purple40

@Preview
@Composable
fun PhraseCard(phrase: Phrase = getRandomPhrase()) {

    val clipboardManager = LocalClipboardManager.current
    val localContext = LocalContext.current

    val copyPhrase: () -> Unit = {
         clipboardManager.setText(AnnotatedString(phrase.phrase))
        Toast.makeText(localContext, "Frase copiada :)", Toast.LENGTH_SHORT).show()
        showInterstitial(localContext);
    }

    val sharePhrase: ()->Unit = {
        showInterstitial(localContext);
        val customSharePhraseContent = "${phrase.phrase}\n\nFrases de Rap: https://play.google.com/store/apps/details?id=principal.fraseparastatus.frasesderapparastatus"
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, customSharePhraseContent)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        localContext.startActivity(shareIntent)
    }

    Card(onClick = { },
        colors = CardDefaults.cardColors(),
        modifier = Modifier.
        fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xffA7ACD9))
                    .padding(20.dp)
                    .heightIn(min = 50.dp)
            ) {
                Column {
                    Text(text = "\"${phrase.phrase}\"", color = Color.Black)
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(text = phrase.singer, color = Color.Black)
                    }
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                Icon(
                    imageVector = FontAwesomeIcons.Regular.Copy,
                    contentDescription = "fortune cookie",
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp)
                        .clickable(onClick = copyPhrase)
                )

                Icon(imageVector = FontAwesomeIcons.Solid.ShareAltSquare,
                    contentDescription = "fortune cookie",
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp)
                        .clickable(onClick = sharePhrase)
                )
            }
        }
    }
}