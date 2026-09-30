package com.example.cinta_3tic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cinta_3tic.databinding.ActivityLoginBinding
import com.example.cinta_3tic.databinding.ActivityMainBinding
import com.example.cinta_3tic.pertemuan_5.LimaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nama = intent.getStringExtra("Nama")
        val umur = intent.getIntExtra("Umur", 0)

        Log.w("Hasil", "Nama: $nama Umur : $umur")
        binding.btnKembali.setOnClickListener {
//            val intentkembali = Intent(this@MainActivity, LoginActivity::class.java)
//            startActivity(intentkembali)
            finish()
        }
        binding.txtNama.text = nama

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tampilkan"){
                    val intentkembali = Intent(this@MainActivity, LoginActivity::class.java)
                    startActivity(intentkembali)
                    Log.e("Info Snackbar","Snackbar ditutup")
                }
                .show()
        }
        binding.btnLima.setOnClickListener {
            val intentlima = Intent(this@MainActivity, LimaActivity::class.java)
            startActivity(intentlima)
        }
        binding.btnAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->

                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->

                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()
        }

    }
}