package br.com.alura.forumaluraapi.controller

import br.com.alura.forumaluraapi.model.Topico
import br.com.alura.forumaluraapi.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<Topico> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Topico { // PathVariable indica que o parâmetro recebido faz parte da URI
        return service.buscarPorId(id)
    }

}
