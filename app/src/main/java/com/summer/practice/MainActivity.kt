package com.summer.practice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val btnLoadImage = findViewById<Button>(R.id.btnLoadImage)
        val btnGoToLogin = findViewById<Button>(R.id.btnBGToLogin)

        val imageUrls = listOf(
            "https://images.unsplash.com/photo-1470071459604-3b5ec3a7fe05?w=600",
            "https://images.unsplash.com/photo-1490750967868-88aa4486c946?w=600",
            "https://images.unsplash.com/photo-1475924156734-496f6cac6ec1?w=600",
            "https://images.unsplash.com/photo-1502136969935-8d8eef54d77b?w=600",
            "https://images.unsplash.com/photo-1503435980610-a51f3ddfee50?w=600",
            "https://images.unsplash.com/photo-1432405972618-c60b0225b8f9?w=600",
            "https://images.unsplash.com/photo-1455218873509-8097305ee378?w=600",
            "https://images.unsplash.com/photo-1506929562872-bb421503ef21?w=600",
            "https://images.unsplash.com/photo-1431794062232-2a99a5431c6c?w=600"
        )

        btnLoadImage.setOnClickListener {
            val randomUrl = imageUrls.random()
            Glide.with(this)
                .load(randomUrl)
                .placeholder(R.color.green)
                .error(R.color.red)
                .into(imageView)
        }

        btnGoToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}