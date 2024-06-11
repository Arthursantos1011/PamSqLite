package com.example.apprevisao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome:EditText = findViewById(R.id.edtNome)
        val edtEndereco:EditText = findViewById(R.id.edtEndereco)
        val edtBairro:EditText = findViewById(R.id.edtBairro)
        val edtCep:EditText = findViewById(R.id.edtCep)
        val edtTel:EditText = findViewById(R.id.edtTel)

        val btnCadastrar:Button = findViewById(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            val intent = Intent(this, RespostaActivity::class.java)
            intent.putExtra("Nome",edtNome.text.toString())
            intent.putExtra("Endereco",edtEndereco.text.toString())
            intent.putExtra("Bairro",edtBairro.text.toString())
            intent.putExtra("Cep",edtCep.text.toString())
            intent.putExtra("Telefone",edtTel.text.toString())
            startActivity(intent)
        }
    }
}