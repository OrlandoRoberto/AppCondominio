package com.example.appcondominio

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReservaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reserva)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolbar= findViewById<Toolbar>(R.id.toolbarReserva)
        toolbar.title = "Reserva"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val rc = findViewById<RecyclerView>(R.id.recycleReserva)
        rc.layoutManager = LinearLayoutManager( this)

        var  reservas = listOf(
            "Academia",
            "Brinquedoteca",
            "Churrasqueira",
            "Sala de festa",
            "Salão de Jogos",)

        rc.adapter = ReservaAdapter(reservas)


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Volta para a tela anterior
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}