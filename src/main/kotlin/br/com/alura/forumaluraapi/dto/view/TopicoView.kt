package br.com.alura.forumaluraapi.dto.view

import java.time.LocalDateTime
import br.com.alura.forumaluraapi.model.StatusTopico

data class TopicoView(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)
