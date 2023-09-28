package com.historias

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.hdodenhof.circleimageview.CircleImageView
import principal.fraseparastatus.frasesderapparastatus.R

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PostAdapter
    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "MainActivity"
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var loading = findViewById<ProgressBar>(R.id.loading)
        adapter = PostAdapter(emptyList<Post>().toTypedArray())
        recyclerView = findViewById(R.id.rv_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter;


        loadAd()
        MobileAds.initialize(this){}
        loadBannerAd()

        // Inicialize o Firebase aqui
        FirebaseApp.initializeApp(this)
        val db = FirebaseFirestore.getInstance()
        db.collection("Frases").addSnapshotListener { querySnapshot, error ->

            if (error != null) {
                // Lidar com erros, se houver algum
                Log.i("Error", error.message.toString())
                return@addSnapshotListener
            }

            Log.i("amount", querySnapshot!!.size().toString())
            val postList = mutableListOf<Post>()

            // Iterar pelos documentos no resultado da consulta
            for (document in querySnapshot!!) {
                val cantor = document.getString("cantor") ?: ""
                val categoria = document.getString("categoria") ?: ""
                val frase = document.getString("frase") ?: ""

                val post = Post(document.id, cantor, categoria, frase)
                postList.add(post)
            }

            // Atualizar o adaptador com a nova lista de histórias
            adapter.setPosts(postList)
            loading.visibility = View.GONE
     }

        var categoriaId:String = "";

        val americano = findViewById<CircleImageView>(R.id.americano)
        val rap = findViewById<CircleImageView>(R.id.rap)
        val trap = findViewById<CircleImageView>(R.id.trap)

        americano.setOnClickListener { goToSelectedPostActivity("Americano") }
        rap.setOnClickListener { goToSelectedPostActivity("Rap") }
        trap.setOnClickListener { goToSelectedPostActivity("Trap") }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        val sharedPrefs = getSharedPreferences("Prefs",Context.MODE_PRIVATE)
        fab.setOnClickListener {
            Log.i("fab","clicked")
            val userId = sharedPrefs.getString("user_id",null);
            if(userId == null){
                goToLoginActivity()
            }
            Log.i("userId",(userId == null).toString())
        }
    }

    private fun goToLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
    private fun goToSelectedPostActivity(categoriaId:String){
        val intent = Intent(this, SelectedPostActivity::class.java)
        intent.putExtra("KEY",categoriaId)
        startActivity(intent)
    }
    private fun showInterstitialAd(){
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }
    }

    private fun loadAd(){
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this, getString(R.string.interstititial_ad), adRequest, object : InterstitialAdLoadCallback() {
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

}