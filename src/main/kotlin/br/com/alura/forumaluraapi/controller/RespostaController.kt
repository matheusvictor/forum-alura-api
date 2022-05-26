package br.com.alura.forumaluraapi.controller

import br.com.alura.forumaluraapi.dto.form.RespostaForm
import br.com.alura.forumaluraapi.model.Resposta
import br.com.alura.forumaluraapi.service.RespostaService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topicos/{id}/respostas")
class RespostaController(private val service: RespostaService) {

    @GetMapping
    fun listarRespostasPorTopico(@PathVariable id: Long): List<Resposta> {
        return this.service.listarRespostasPorTopico(id)
    }

    @PostMapping
    fun cadastrar(@PathVariable id: Long, @RequestBody @Valid dto: RespostaForm) {
        service.cadastrarResposta(id, dto)
    }

}