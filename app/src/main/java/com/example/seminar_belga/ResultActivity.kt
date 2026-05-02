package com.example.seminar_belga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // =============================
        // INIT VIEW
        // =============================
        val tvNama = findViewById<TextView>(R.id.tvNama)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvHp = findViewById<TextView>(R.id.tvHp)
        val tvGender = findViewById<TextView>(R.id.tvGender)
        val tvSeminar = findViewById<TextView>(R.id.tvSeminar)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // =============================
        // AMBIL DATA DARI INTENT
        // =============================
        val nama = intent.getStringExtra("nama") ?: "-"
        val email = intent.getStringExtra("email") ?: "-"
        val hp = intent.getStringExtra("hp") ?: "-"
        val gender = intent.getStringExtra("gender") ?: "-" // ✅ TAMBAHAN
        val seminar = intent.getStringExtra("seminar") ?: "-"

        // =============================
        // SET DATA KE VIEW (UI BAGUS)
        // =============================
        tvNama.text = "👤 $nama"
        tvEmail.text = "📧 $email"
        tvHp.text = "📱 $hp"

        // 👇 BONUS: ICON DINAMIS
        tvGender.text = if (gender == "Laki-laki") {
            "👨 $gender"
        } else {
            "👩 $gender"
        }

        tvSeminar.text = "🎯 $seminar"

        // =============================
        // BUTTON BACK
        // =============================
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}