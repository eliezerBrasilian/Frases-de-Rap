package com.historias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.random.Random
import android.widget.TextView
import android.widget.ImageView
import android.widget.Button
import principal.fraseparastatus.frasesderapparastatus.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val frases = arrayOf(
            Frase("Toda de Gucci, ela só anda chique.","Jé Santiago"),
            Frase("Essa party tá lotada porquê é o pai que tá no fly.","Derek"),
            Frase("Não tinha nada mais eu tinha amor.\nO objetivo era ser bem maior.", "Raffa Moreira"),
            Frase("O nosso destino é uma caixa de surpresa.","Haikaiss"),
            Frase("Elas acham que eu sou gringo.","Derek"),
        )
        var indexRandom = Random.nextInt(frases.size)
        val frase = frases[indexRandom].frase
        val cantor = frases[indexRandom].cantor
        Log.i("frase",frase)

        val fraseTextView:TextView = findViewById(R.id.frase)
        val cantorTextView:TextView = findViewById(R.id.cantor)
        fraseTextView.text = frase
        cantorTextView.text = cantor

        val bgActivity:ImageView = findViewById(R.id.bg_activity_splash)
        val imagensFundo = arrayOf(
            ImagemFundo(R.drawable.unsplash_1),
            ImagemFundo(R.drawable.unsplash_2),
            ImagemFundo(R.drawable.unsplash_3),
            ImagemFundo(R.drawable.unsplash_4),
        )
        indexRandom = Random.nextInt(imagensFundo.size)
        val imagem = imagensFundo[indexRandom]
        bgActivity.setImageResource(imagem.imagemId)

        val btn:Button = findViewById(R.id.btn_procurar_mais_frases)
        btn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    data class ImagemFundo(val imagemId:Int)
}