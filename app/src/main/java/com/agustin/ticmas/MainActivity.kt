package com.agustin.ticmas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.agustin.ticmas.databinding.ActivityMainBinding
import com.agustin.ticmas.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel.resultado.observe(this, Observer { resultado ->
            binding.resultado.text = resultado
        })

        binding.btnComparar.setOnClickListener {
            val primerTexto = binding.primerText.text.toString()
            val segundoTexto = binding.segundoText.text.toString()

            viewModel.actualizarDatos(primerTexto, segundoTexto)
            viewModel.compararTextos()
        }
    }
}
