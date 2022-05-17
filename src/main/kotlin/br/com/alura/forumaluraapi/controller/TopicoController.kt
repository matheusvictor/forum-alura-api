package br.com.alura.forumaluraapi.controller

import br.com.alura.forumaluraapi.dto.form.TopicoForm
import br.com.alura.forumaluraapi.dto.view.TopicoView
import br.com.alura.forumaluraapi.service.TopicoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView { // PathVariable indica que o parâmetro recebido faz parte da URI
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: TopicoForm) {
        service.cadastrarTopico(dto)
    }

}
