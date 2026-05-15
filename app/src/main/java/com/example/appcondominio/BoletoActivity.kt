package com.example.appcondominio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BoletoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boleto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val boletos = listOf(
            Boleto("Taxa condominio", "R$ 150,00", "Vencimento: 15/05/2026"),
            Boleto("Taxa condominio", "R$ 300,00", "Vencimento: 20/05/2026"),
            Boleto("Taxa condominio", "R$ 90,00", "Vencimento: 25/05/2026"),
            Boleto("Taxa condominio", "R$ 120,00", "Vencimento: 30/05/2026"),
            Boleto("Taxa condominio", "R$ 1.200,00", "Vencimento: 05/06/2026"),
                    Boleto("Taxa condominio", "R$ 150,00", "Vencimento: 15/05/2026"),
        Boleto("Taxa condominio", "R$ 300,00", "Vencimento: 20/05/2026"),
        Boleto("Taxa condominio", "R$ 90,00", "Vencimento: 25/05/2026"),
        Boleto("Taxa condominio", "R$ 120,00", "Vencimento: 30/05/2026"),
        Boleto("Taxa condominio", "R$ 1.200,00", "Vencimento: 05/06/2026")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BoletoAdapter(boletos)
    }
}