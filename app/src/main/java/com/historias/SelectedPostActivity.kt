package com.historias


import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import principal.fraseparastatus.frasesderapparastatus.R

class SelectedPostActivity : AppCompatActivity() {
    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "MainActivity"
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_post)
        val key = intent.getStringExtra("KEY")
        loadPosts(key,this)

        val navbar = findViewById<LinearLayout>(R.id.navbar)
        val titulo = findViewById<TextView>(R.id.titulo_categoria)
        titulo.text = key.toString()
        navbar.setOnClickListener {
          onBackPressed()
        }

        checkDarkMode()
        loadAd()
        MobileAds.initialize(this){}
        loadBannerAd()
    }

    private fun showInterstitialAd(){
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }
    }

    override fun onBackPressed() {
        showInterstitialAd()
        super.onBackPressed()
    }
    private fun loadAd(){
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,getString(R.string.interstititial_ad), adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
               // Log.d(TAG, adError?.toString())
                Log.i("TAG","Ad was not shown")
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(TAG, "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })
    }

    private fun loadBannerAd(){
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    private fun checkDarkMode(){
        val isDarkMode = (resources.configuration.uiMode
                and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
        if(isDarkMode){
            val leftIcon = findViewById<ImageView>(R.id.left_icon)

            val largura = 40
            val altura = 40
            leftIcon.layoutParams.width = largura
            leftIcon.layoutParams.height = altura
            leftIcon.setImageResource(R.drawable.left_white)
        }

    }

    private fun loadPosts(key: String?, thisContext: SelectedPostActivity){
        var recyclerView:RecyclerView = findViewById(R.id.rv_list)
        var loading = findViewById<ProgressBar>(R.id.loading)
        recyclerView.layoutManager = LinearLayoutManager(thisContext)

        var adapter = PostAdapter(emptyList<Post>().toTypedArray())

        recyclerView.adapter = adapter
        FirebaseApp.initializeApp(thisContext)
        val db = FirebaseFirestore.getInstance()

        db.collection("Frases").
        whereEqualTo("categoria",key)
            .get()
            .addOnSuccessListener {
                querySnapshot ->

                var postlist = mutableListOf<Post>()
                for(document in querySnapshot!!){
                    val id:String = document.id
                    val cantor = document.getString("cantor")?: ""
                    val frase = document.getString("frase")?:""
                    Log.i("Frase",frase)

                    val post = Post(id,cantor,null,frase)
                    postlist.add(post)
                }

                adapter.setPosts(postlist)
                loading.visibility = View.GONE
            }
    }

}