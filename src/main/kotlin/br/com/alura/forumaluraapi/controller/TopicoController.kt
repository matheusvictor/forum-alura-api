package br.com.alura.forumaluraapi.controller

import br.com.alura.forumaluraapi.dto.form.AtualizacaoTopicoForm
import br.com.alura.forumaluraapi.dto.form.TopicoForm
import br.com.alura.forumaluraapi.dto.view.TopicoView
import br.com.alura.forumaluraapi.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
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
    fun cadastrar(
        @RequestBody @Valid form: TopicoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView> {
        val topicoView = service.cadastrarTopico(form)
        val uri = uriBuilder.path("topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm): ResponseEntity<TopicoView> {
        val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // retorno 204, deleção feita com sucesso
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

}
