package com.curso.android.app.practica.proyecto_argprog40.ViewModel

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.proyecto_argprog40.Model.Comparar

class MainViewModel:ViewModel() {
    val compara: LiveData<Comparar> get() = _compara
    private var _compara = MutableLiveData<Comparar>(Comparar(""))

    fun compararDatos(E1:String,E2:String){
        if(E1==E2){    //if(E1.text.toString()==E2.text.toString()){
            escribirRespuesta("Los datos ingresados son IGUALES")
        } else {
            escribirRespuesta("Los datos ingresados son DISTINTOS")
        }
    }

    fun escribirRespuesta(Resp:String){
        _compara.value = Comparar(Resp)
    }
}