package br.com.alura.forumaluraapi.mapper

interface Mapper<T, U> {

    fun converte(t: T): U

}
