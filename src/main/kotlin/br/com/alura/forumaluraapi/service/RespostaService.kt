package br.com.alura.forumaluraapi.service

import br.com.alura.forumaluraapi.dto.form.RespostaForm
import br.com.alura.forumaluraapi.mapper.RespostaFormMapper
import br.com.alura.forumaluraapi.model.*
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService(
    private var respostas: MutableList<Resposta> = mutableListOf(),
    private val respostaFormMapper: RespostaFormMapper
) {

    fun listarRespostasPorTopico(idTopico: Long): List<Resposta> {
        return this.respostas.stream().filter { resposta ->
            resposta.topico.id == idTopico
        }.collect(Collectors.toList())
    }

    fun cadastrarResposta(form: RespostaForm) {
        val novaResposta: Resposta = respostaFormMapper.converte(form)
        novaResposta.id = respostas.size.toLong() + 1
        respostas.add(novaResposta)
    }

}