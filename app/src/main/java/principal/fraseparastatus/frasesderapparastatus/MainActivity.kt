package principal.fraseparastatus.frasesderapparastatus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import principal.fraseparastatus.frasesderapparastatus.data.loadInterstitial
import principal.fraseparastatus.frasesderapparastatus.data.removeInterstitial
import principal.fraseparastatus.frasesderapparastatus.data.showInterstitial
import principal.fraseparastatus.frasesderapparastatus.navigation.AppNavigation
import principal.fraseparastatus.frasesderapparastatus.ui.theme.FrasesDeRapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        loadInterstitial(this)
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            FrasesDeRapTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(innerPadding)
                }
            }
        }
    }

    override fun onDestroy() {
        removeInterstitial()
        super.onDestroy()
    }
}

