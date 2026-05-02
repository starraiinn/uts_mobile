package com.example.seminar_belga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = intent.getStringExtra("username")
        val tvUser = findViewById<TextView>(R.id.tvUser)
        val btnDaftar = findViewById<Button>(R.id.btnDaftar)

        tvUser.text = "Selamat datang, $username"

        btnDaftar.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }
}