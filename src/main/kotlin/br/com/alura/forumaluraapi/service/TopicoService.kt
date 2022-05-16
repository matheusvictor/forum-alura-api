package br.com.alura.forumaluraapi.service

import br.com.alura.forumaluraapi.model.Curso
import br.com.alura.forumaluraapi.model.Topico
import br.com.alura.forumaluraapi.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico1 = Topico(
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

        val topico2 = Topico(
            id = 2,
            titulo = "Dúvida Spring",
            mensagem = "O que é Spring?",
            curso = Curso(
                id = 1,
                nomeCurso = "Koltin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nomeUsuario = "Chico Bento",
                email = "chicobento@email.com"
            )
        )

        topicos = listOf(topico1, topico2)
    }

    fun listar(): List<Topico> {
        return this.topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { topico ->
            topico.id == id
        }.findFirst().get()
    }

}
