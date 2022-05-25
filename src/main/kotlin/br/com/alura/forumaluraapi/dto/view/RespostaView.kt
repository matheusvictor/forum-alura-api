package br.com.alura.forumaluraapi.dto.view

data class RespostaView(
    val id: Long?,
    val idAutor: Long,
    val idTopico: Long,
    val mensagem: String,
    val solucao: Boolean
)
