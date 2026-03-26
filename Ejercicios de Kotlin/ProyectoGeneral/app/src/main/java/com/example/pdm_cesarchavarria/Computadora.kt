package com.example.pdm_cesarchavarria

import android.util.Log

class Computadora(
    var ram: Int,
    var almacenamiento: Int,
    var sistemaOperativo: String
) {

    var encendida = false
    var programasInstalados = mutableListOf<String>()

    fun encender() {
        encendida = true
        Log.d("INFO", "Computadora encendida")
    }

    fun apagar() {
        encendida = false
        Log.d("INFO", "Computadora apagada")
    }

    fun agregarPrograma(nombre: String) {
        programasInstalados.add(nombre)
        Log.d("INFO", "Programa agregado: $nombre")
    }

    fun programasDeEsteAnio(): List<String> {
        return programasInstalados.filter { it.contains("2026") }
    }
}