package br.com.alura.forumaluraapi.dto.form

data class TopicoForm(
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)
