package com.example.revisao

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.revisao.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {



    private lateinit var binding: ActivityMainBinding
    private var isPar: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        capturarClicks()

    }

    private fun capturarClicks(){
        binding.textView1.setOnClickListener {
            checarResultado(1, escolherPeloApp(isPar))
        }
        binding.textView1.setOnClickListener {
            checarResultado(2, escolherPeloApp(isPar))
        }
        binding.textView1.setOnClickListener {
            checarResultado(3, escolherPeloApp(isPar))
        }
        binding.textView1.setOnClickListener {
            checarResultado(4, escolherPeloApp(isPar))
        }
        binding.textView1.setOnClickListener {
            checarResultado(5, escolherPeloApp(isPar))
        }
        binding.textView1.setOnClickListener {
            isPar = true
        }
        binding.textView1.setOnClickListener {
            isPar = false
        }

    }

    private fun checarResultado(escolhaUsuario: Int, escolhaApp: Int?) {
        if (escolhaApp == null)
            binding.textViewResultado.text = "Escolha entre par e ímpar"
        else {
            val resultadoEhPar = (escolhaUsuario + escolhaApp) % 2 == 0
            if (isPar == true && resultadoEhPar){
                binding.textViewResultado.text = "Você ganhou"
            }else{
                binding.textViewResultado.text = "Voce perdeu"
            }
        }

    }

    private fun escolherPeloApp(isPar: Boolean?): Int? {
        if (isPar == null) return  null
        var escolhaApp = Random.nextInt(5)
        binding.textViewResultado.text = escolhaApp.toString()
        return escolhaApp
    }
}

