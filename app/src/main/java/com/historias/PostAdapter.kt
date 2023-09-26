package com.historias

import android.os.Vibrator
import android.view.ViewGroup
import android.view.View
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.VibratorManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import principal.fraseparastatus.frasesderapparastatus.R


class PostAdapter(private var posts: Array<Post>) :
    RecyclerView.Adapter<PostAdapter.Bandeja>() {

    class Bandeja(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cantor: TextView = itemView.findViewById(R.id.cantor)
        val frase: TextView = itemView.findViewById(R.id.frase)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Bandeja {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item, parent, false)
        return Bandeja(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: Bandeja, position: Int) {
        val post = posts[position]
        holder.cantor.text = post.cantor
        holder.frase.text = post.frase

        holder.itemView.setOnClickListener {
            copyToClipboard(it, post)
        }
        holder.itemView.setOnLongClickListener {
            copyToClipboard(it, post)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                vibrateOnClick(it)
            }
            true
        }
    }


    @RequiresApi(Build.VERSION_CODES.Q)
    private fun vibrateOnClick(it: View) {
        if (it.context != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                val vibratorManager =
                    it.context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                val vibrator = vibratorManager.defaultVibrator
                vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK))
            } else {
                val v = it.context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                if (Build.VERSION.SDK_INT >= 26) {
                    v.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK))
                } else {
                    v.vibrate(200L)
                }
            }
        }
    }

    private fun copyToClipboard(it: View, post: Post) {
        val clipboard = getSystemService(it.context, ClipboardManager::class.java)
        clipboard?.setPrimaryClip(ClipData.newPlainText("frase", post.frase))
        Toast.makeText(it.context, "Frase copiada", Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setPosts(posts: List<Post>) {
        this.posts = posts.toTypedArray()
        notifyDataSetChanged()
    }


}