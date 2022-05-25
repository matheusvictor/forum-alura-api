package br.com.alura.forumaluraapi.dto.form

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class RespostaForm(
    @field:NotEmpty @field:Size(min = 5, max = 500) val mensagem: String,
    val idAutor: Long,
    val idTopico: Long,
    val solucao: Boolean
)
