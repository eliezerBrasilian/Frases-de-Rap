package principal.fraseparastatus.frasesderapparastatus.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import principal.fraseparastatus.frasesderapparastatus.data.Screens
import principal.fraseparastatus.frasesderapparastatus.navigation.Route
import principal.fraseparastatus.frasesderapparastatus.ui.components.BackgroundImage
import principal.fraseparastatus.frasesderapparastatus.ui.components.MainPhraseCard

@Composable
fun SplashScreen(nav: NavHostController) {
    BackgroundImage {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween) {

            Text(text = "Frases de Rap",
                color = Color.White,
                fontSize = 22.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 20.dp))


            MainPhraseCard()

            Button(onClick = {
                nav.navigate(Route.MainRoute.name) {
                    popUpTo(Route.SplashRoute.name) {
                        inclusive = true
                    }
                }
            },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text(text = "Exibir todas frases", color = Color.White)
            }

        }
    }
}



