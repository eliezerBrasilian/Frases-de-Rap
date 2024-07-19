package principal.fraseparastatus.frasesderapparastatus.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import principal.fraseparastatus.frasesderapparastatus.data.officialBannerId

@Preview
@Composable
fun BannerAdd(modifier: Modifier = Modifier, bannerSize: AdSize = AdSize.BANNER){
    val isInEditMode = LocalInspectionMode.current

    Box(modifier = Modifier.padding(10.dp)){
        AndroidView(
            modifier = modifier.fillMaxWidth(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(bannerSize)
                    adUnitId = officialBannerId
                    loadAd(AdRequest.Builder().build())
                }
            })
    }


/*    if (isInEditMode) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(horizontal = 2.dp, vertical = 6.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            text = "Advert Here",
        )
    } else {

        AndroidView(
            modifier = modifier.fillMaxWidth(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(bannerSize)
                    adUnitId = bannerIdTeste
                    loadAd(AdRequest.Builder().build())
                }
            })
    }*/
}