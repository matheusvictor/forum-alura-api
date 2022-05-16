package br.com.alura.forumaluraapi.controller

import br.com.alura.forumaluraapi.model.Topico
import br.com.alura.forumaluraapi.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<Topico> {
        return service.listar()
    }

}
