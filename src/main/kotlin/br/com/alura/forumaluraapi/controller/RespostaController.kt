package br.com.alura.forumaluraapi.controller

import br.com.alura.forumaluraapi.model.Resposta
import br.com.alura.forumaluraapi.service.RespostaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos/{id}/respostas")
class RespostaController(private val service: RespostaService) {

    @GetMapping
    fun listarRespostasPorTopico(@PathVariable id: Long): List<Resposta> {
        return this.service.listarRespostasPorTopico(id)
    }
}