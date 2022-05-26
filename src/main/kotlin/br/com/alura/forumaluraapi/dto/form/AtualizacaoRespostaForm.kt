package br.com.alura.forumaluraapi.dto.form

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizacaoRespostaForm(
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min = 5, max = 500) val mensagem: String,
    val solucao: Boolean
)
