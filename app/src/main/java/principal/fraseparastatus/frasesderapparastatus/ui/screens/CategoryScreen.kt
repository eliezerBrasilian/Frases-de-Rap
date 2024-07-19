package principal.fraseparastatus.frasesderapparastatus.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import principal.fraseparastatus.frasesderapparastatus.R
import principal.fraseparastatus.frasesderapparastatus.data.Phrase
import principal.fraseparastatus.frasesderapparastatus.data.categories
import principal.fraseparastatus.frasesderapparastatus.data.getPhrases
import principal.fraseparastatus.frasesderapparastatus.data.phrases
import principal.fraseparastatus.frasesderapparastatus.ui.components.BannerAdd
import principal.fraseparastatus.frasesderapparastatus.ui.components.CategoryCard
import principal.fraseparastatus.frasesderapparastatus.ui.components.ColapseListRowText
import principal.fraseparastatus.frasesderapparastatus.ui.components.ExpandListRowText
import principal.fraseparastatus.frasesderapparastatus.ui.components.PhraseCard
import principal.fraseparastatus.frasesderapparastatus.ui.components.SearchBarComponent
import principal.fraseparastatus.frasesderapparastatus.ui.components.TitleWithCrown


@Composable
fun CategoryScreen(nav: NavHostController, categoryName: String?) {
    var defaultPhrases by remember { mutableStateOf(phrases) }
    var filteredList by remember { mutableStateOf(emptyList<Phrase>()) }

    LaunchedEffect(key1 = null) {
        if (categoryName != null) {
            defaultPhrases = getPhrases(categoryName.toString())
        }
    }

    var query by remember { mutableStateOf("") }

    var isSearching by remember { mutableStateOf(false) }

    val onQueryChange: (String) -> Unit = {
        query = it

        isSearching = true
        filteredList = emptyList()

        if(it.isEmpty()){
            isSearching = false
        }

        val list =  defaultPhrases.filter { phrase ->
            phrase.phrase.contains(query, ignoreCase = true)
        }

        filteredList = list
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.clickable{
                nav.popBackStack()
            }) {
            Icon(imageVector = FontAwesomeIcons.Solid.ArrowLeft, contentDescription = null,
                modifier = Modifier.size(20.dp))
            Text(text = categoryName.toString(), fontSize = 18.sp)
        }
            Spacer(modifier = Modifier.height(20.dp))
            BannerAdd(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(20.dp))
            SearchBarComponent(query = query, onQueryChange = onQueryChange)
            Spacer(modifier = Modifier.height(20.dp))


        LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
            items(if(isSearching && filteredList.isNotEmpty())filteredList else defaultPhrases) { phrase ->
                PhraseCard(phrase)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        BannerAdd(modifier = Modifier.fillMaxWidth())

    }
}