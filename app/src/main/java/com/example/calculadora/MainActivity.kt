package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root

        setContentView(view)

        binding.button.setOnClickListener {
            calcularIMC()
        }

    }

    fun calcularIMC() {
        var altura: Float = binding.altura.text.toString().toFloat()
        var peso: Float = binding.peso.text.toString().toFloat()

        val resultado = peso / (altura * altura)

        if (resultado < 18){
            binding.resultado.text = "Resultado: Magreza %.2f".format(resultado)
        }
        if (resultado >= 18.6 && resultado <= 24){
            binding.resultado.text = "Resultado: Peso Normal %.2f".format(resultado)
        }
        if (resultado >= 25 && resultado <= 29){
            binding.resultado.text = "Resultado: Sobrepeso %.2f".format(resultado)
        }
        if (resultado > 30){
            binding.resultado.text = "Resultado: Obesidade %.2f".format(resultado)
        }
    }
}