package com.example.seminar_belga

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {

    lateinit var etNama: EditText
    lateinit var etEmail: EditText
    lateinit var etHp: EditText
    lateinit var rgGender: RadioGroup
    lateinit var spSeminar: Spinner
    lateinit var cbSetuju: CheckBox
    lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        // =============================
        // INIT VIEW
        // =============================
        etNama = findViewById(R.id.etNama)
        etEmail = findViewById(R.id.etEmail)
        etHp = findViewById(R.id.etHp)
        rgGender = findViewById(R.id.rgGender)
        spSeminar = findViewById(R.id.spSeminar)
        cbSetuju = findViewById(R.id.cbSetuju)
        btnSubmit = findViewById(R.id.btnSubmit)

        // =============================
        // DATA SEMINAR
        // =============================
        val seminarList = listOf(
            "Pengembangan Diri",
            "Kewirausahaan",
            "Public Speaking",
            "Manajemen Waktu",
            "Kesehatan Mental",
            "Literasi Keuangan",
            "Kepemimpinan",
            "Karier & Dunia Kerja"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            seminarList
        )
        spSeminar.adapter = adapter

        // =============================
        // REAL TIME VALIDATION
        // =============================

        etNama.addTextChangedListener(simpleWatcher { text ->
            etNama.error = if (text.isEmpty()) "Nama wajib diisi" else null
        })

        etEmail.addTextChangedListener(simpleWatcher { text ->
            etEmail.error = if (!text.contains("@")) "Email tidak valid" else null
        })

        etHp.addTextChangedListener(simpleWatcher { text ->
            etHp.error = if (!text.matches(Regex("^08[0-9]{8,11}$"))) {
                "Nomor HP tidak valid"
            } else null
        })

        // =============================
        // BUTTON SUBMIT
        // =============================
        btnSubmit.setOnClickListener {
            if (validasi()) {
                tampilDialog()
            }
        }
    }

    // =============================
    // VALIDASI FINAL
    // =============================
    fun validasi(): Boolean {

        val nama = etNama.text.toString()
        val email = etEmail.text.toString()
        val hp = etHp.text.toString()

        if (nama.isEmpty()) {
            etNama.error = "Nama wajib diisi"
            return false
        }

        if (!email.contains("@")) {
            etEmail.error = "Email tidak valid"
            return false
        }

        if (!hp.matches(Regex("^08[0-9]{8,11}$"))) {
            etHp.error = "HP tidak valid"
            return false
        }

        if (rgGender.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Pilih jenis kelamin", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!cbSetuju.isChecked) {
            Toast.makeText(this, "Harus menyetujui syarat", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    // =============================
    // DIALOG KONFIRMASI
    // =============================
    fun tampilDialog() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi")
            .setMessage("Apakah data sudah benar?")
            .setPositiveButton("Ya") { _, _ ->
                kirimData()
            }
            .setNegativeButton("Tidak", null)
            .show()
    }

    // =============================
    // KIRIM DATA KE RESULT
    // =============================
    fun kirimData() {

        val gender = when (rgGender.checkedRadioButtonId) {
            R.id.rbLaki -> "Laki-laki"
            R.id.rbPerempuan -> "Perempuan"
            else -> "-"
        }

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("nama", etNama.text.toString())
        intent.putExtra("email", etEmail.text.toString())
        intent.putExtra("hp", etHp.text.toString())
        intent.putExtra("gender", gender)
        intent.putExtra("seminar", spSeminar.selectedItem.toString())

        startActivity(intent)
    }

    // =============================
    // HELPER TEXTWATCHER (BIAR RAPI)
    // =============================
    fun simpleWatcher(afterText: (String) -> Unit): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                afterText(s.toString())
            }
        }
    }
}