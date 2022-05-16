package br.com.alura.forumaluraapi.service

import br.com.alura.forumaluraapi.model.Curso
import br.com.alura.forumaluraapi.model.Resposta
import br.com.alura.forumaluraapi.model.Topico
import br.com.alura.forumaluraapi.model.Usuario
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService(private var respostas: List<Resposta>) {

    init {
        val curso = Curso(
            id = 1,
            nomeCurso = "Kotlin",
            categoria = "Programacao"
        )
        val autor = Usuario(
            id = 1,
            nomeUsuario = "Ana da Silva",
            email = "ana@email.com"
        )
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = curso,
            autor = autor
        )

        val resposta = Resposta(
            id = 1,
            mensagem = "Resposta 1",
            autor = autor,
            topico = topico,
            solucao = false
        )

        val resposta2 = Resposta(
            id = 2,
            mensagem = "Resposta 2",
            autor = autor,
            topico = topico,
            solucao = false
        )

        respostas = listOf(resposta, resposta2)
    }

    fun listarRespostasPorTopico(idTopico: Long): List<Resposta> {
        return this.respostas.stream().filter { resposta ->
            resposta.topico.id == idTopico
        }.collect(Collectors.toList())
    }

}