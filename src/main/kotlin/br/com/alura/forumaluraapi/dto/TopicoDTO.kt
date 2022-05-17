package br.com.alura.forumaluraapi.dto

data class TopicoDTO(
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)
