package principal.fraseparastatus.frasesderapparastatus.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import principal.fraseparastatus.frasesderapparastatus.data.Phrase
import principal.fraseparastatus.frasesderapparastatus.data.Screens
import principal.fraseparastatus.frasesderapparastatus.data.categories
import principal.fraseparastatus.frasesderapparastatus.data.phrases
import principal.fraseparastatus.frasesderapparastatus.ui.components.BannerAdd
import principal.fraseparastatus.frasesderapparastatus.ui.components.CategoryCard
import principal.fraseparastatus.frasesderapparastatus.ui.components.ColapseListRowText
import principal.fraseparastatus.frasesderapparastatus.ui.components.ExpandListRowText
import principal.fraseparastatus.frasesderapparastatus.ui.components.PhraseCard
import principal.fraseparastatus.frasesderapparastatus.ui.components.SearchBarComponent
import principal.fraseparastatus.frasesderapparastatus.ui.components.TitleWithCrown


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(nav:NavHostController) {
    var defaultPhrases by remember { mutableStateOf(phrases) }
    var filteredList by remember { mutableStateOf(emptyList<Phrase>()) }
    var expanded by remember{mutableStateOf(false)}

    var query by remember { mutableStateOf("") }

    var isSearching by remember { mutableStateOf(false) }

    val onQueryChange: (String) -> Unit = {
        query = it

        isSearching = true
        filteredList = emptyList()

        if(it.isEmpty()){
            isSearching = false
        }

       var list =  defaultPhrases.filter { phrase ->
            phrase.phrase.contains(query, ignoreCase = true)
       }

        filteredList = list
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
    ) {

        if(!expanded){
            TitleWithCrown()
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Diversas frases e trechos de músicas que foram usadas por cantores famosos para você usar",
                fontSize = 16.sp, fontWeight = FontWeight.W300,
                color = Color.Gray)
            Spacer(modifier = Modifier.height(20.dp))
            SearchBarComponent(query = query, onQueryChange = onQueryChange)

            if(!isSearching){
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Categorias", fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))

                LazyRow(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                    items(categories){
                        CategoryCard(it){
                            nav.navigate(Screens.CategoryScreen.name + "/${it.category.name}")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Todas as frases", fontSize = 17.sp, fontWeight = FontWeight.Bold)
                ExpandListRowText(){
                    expanded = !expanded
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        if(expanded){
            ColapseListRowText(){
                expanded = !expanded
            }
        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
            items(if(isSearching && filteredList.size > 0)filteredList else defaultPhrases) { phrase ->
               PhraseCard(phrase)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        BannerAdd(modifier = Modifier.fillMaxWidth())

    }
}

