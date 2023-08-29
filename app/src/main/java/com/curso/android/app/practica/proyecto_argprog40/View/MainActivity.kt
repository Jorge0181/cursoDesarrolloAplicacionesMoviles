package com.curso.android.app.practica.proyecto_argprog40.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import com.curso.android.app.practica.proyecto_argprog40.R
import com.curso.android.app.practica.proyecto_argprog40.ViewModel.MainViewModel
import com.curso.android.app.practica.proyecto_argprog40.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.compara.observe(this){
            println("Respuesta: ${it.respuesta}")
            binding.textView1.text = it.respuesta
        }

        binding.btnComparar.setOnClickListener{
            val E1:EditText = findViewById(R.id.editText1)
            val E2:EditText = findViewById(R.id.editText2)

            mainViewModel.compararDatos(E1.text.toString(),E2.text.toString())
        }
    }
}
