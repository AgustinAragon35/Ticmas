package com.agustin.ticmas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.agustin.ticmas.model.Datos


class MainViewModel: ViewModel() {

    private val _datos = MutableLiveData<Datos>()
    private val _resultado = MutableLiveData<String>()

    val datos: LiveData<Datos>
        get() = _datos

    val resultado: LiveData<String>
        get() = _resultado

    fun actualizarDatos(primerTexto: String, segundoTexto: String) {
        _datos.value = Datos(primerTexto, segundoTexto)
    }

    fun compararTextos() {
        val datos = _datos.value
        if (datos != null) {
            if(!datos.primerTexto.toString().isEmpty() && !datos.segundoTexto.toString().isEmpty()){
                if (datos.primerTexto.equals(datos.segundoTexto, ignoreCase = true)) {
                    _resultado.value = "Los textos son iguales"
                } else {
                    _resultado.value = "Los textos no son iguales"
                }
            }

        }
    }

}