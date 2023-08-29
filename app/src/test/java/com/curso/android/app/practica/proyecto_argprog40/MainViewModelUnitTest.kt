package com.curso.android.app.practica.proyecto_argprog40

import android.widget.EditText
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.core.text.set
import com.curso.android.app.practica.proyecto_argprog40.ViewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun Setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun MainViewModel_checkInitValue() = runTest {
        val valor = viewModel.compara.value?.respuesta
        assertEquals("",valor)
    }

    @Test
    fun MainViewModel_compararCadenasIguales() = runTest {
        launch {
            viewModel.compararDatos("AA","AA")
        }

        advanceUntilIdle()

        var valor = viewModel.compara.value?.respuesta
        assertEquals("Los datos ingresados son IGUALES",valor)
    }

    @Test
    fun MainViewModel_compararCadenasDistintas() = runTest {
        launch {
            viewModel.compararDatos("AA","BBB")
        }

        advanceUntilIdle()

        var valor = viewModel.compara.value?.respuesta
        assertEquals("Los datos ingresados son DISTINTOS",valor)
    }
}