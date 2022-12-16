package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding()
        onClickCalculate()
    }

    fun viewBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
    }
    fun onClickCalculate(){
        binding.button.setOnClickListener {
            calculateBMI()
        }
    }
    fun calculateBMI() {
        val height: Float = binding.height.text.toString().toFloat()
        val weight: Float = binding.weight.text.toString().toFloat()

        val magreza = "Magreza"
        val pesoNormal = "Peso Normal"
        val sobrepeso  = "Sobrepeso"
        val obesidade = "Obesidade"

        val resultBMI = weight/(height * height)

        if(resultBMI < 18) {
            binding.result.text = "%.2f".format(resultBMI)
            binding.rating.text = magreza
        }
        if (resultBMI in 18.6..24.0) {
            binding.result.text = "%.2f".format(resultBMI)
            binding.rating.text = pesoNormal
        }
        if (resultBMI in 25.0..29.0) {
            binding.result.text = "%.2f".format(resultBMI)
            binding.rating.text = sobrepeso
        }
        if (resultBMI > 30) {
            binding.result.text = "%.2f".format(resultBMI)
            binding.rating.text = obesidade
        }
    }
}