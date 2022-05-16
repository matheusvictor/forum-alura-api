package br.com.alura.forumaluraapi.controller

import br.com.alura.forumaluraapi.model.Curso
import br.com.alura.forumaluraapi.model.Topico
import br.com.alura.forumaluraapi.model.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController {

    @GetMapping
    fun listar(): List<Topico> {
        val topico = Topico(
            id = 1,
            titulo = "Dúvida Kotlin",
            mensagem = "Variáveis de ambiente",
            curso = Curso(
                id = 1,
                nomeCurso = "Koltin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nomeUsuario = "Loro José",
                email = "zezinho@email.com"
            )
        )
        return Arrays.asList(topico, topico)
    }

}
