package br.com.alura.forumaluraapi.controller

import br.com.alura.forumaluraapi.dto.TopicoDTO
import br.com.alura.forumaluraapi.model.Topico
import br.com.alura.forumaluraapi.service.TopicoService
import org.springframework.web.bind.annotation.*

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

    @PostMapping
    fun cadastrar(@RequestBody dto: TopicoDTO) {
        service.cadastrarTopico(dto)
    }

}
