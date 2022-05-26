package br.com.alura.forumaluraapi.service

import br.com.alura.forumaluraapi.dto.form.AtualizacaoRespostaForm
import br.com.alura.forumaluraapi.dto.form.RespostaForm
import br.com.alura.forumaluraapi.dto.view.RespostaView
import br.com.alura.forumaluraapi.exception.NotFoundException
import br.com.alura.forumaluraapi.mapper.RespostaFormMapper
import br.com.alura.forumaluraapi.mapper.RespostaViewMapper
import br.com.alura.forumaluraapi.model.*
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService(
    private var respostas: MutableList<Resposta> = mutableListOf(),
    private val respostaFormMapper: RespostaFormMapper,
    private val respostaViewMapper: RespostaViewMapper,
    private val topicoService: TopicoService
) {

    fun listarRespostasPorTopico(idTopico: Long): List<Resposta> {
        return this.respostas.stream().filter { resposta ->
            resposta.topico.id == idTopico
        }.collect(Collectors.toList())
    }

    fun cadastrarResposta(idTopico: Long, form: RespostaForm) {
        val novaResposta: Resposta = respostaFormMapper.converte(form)
        novaResposta.id = respostas.size.toLong() + 1
        novaResposta.topico = topicoService.obterTopico(idTopico)
        respostas.add(novaResposta)
    }

    fun atualizar(form: AtualizacaoRespostaForm): RespostaView {
        val respostaOriginal = respostas.stream().filter { r ->
            r.id == form.id
        }.findFirst().get()

        val respostaAtualizada = Resposta(
            id = form.id,
            mensagem = form.mensagem,
            autor = respostaOriginal.autor,
            topico = respostaOriginal.topico,
            solucao = form.solucao
        )
        respostas.remove(respostaOriginal)
        respostas.add(respostaAtualizada) // cria um novo Topico e os atributos que não veem do form, permanecem iguais ao do topico capturado
        return respostaViewMapper.converte(respostaAtualizada)
    }

    fun deletar(id: Long) {
        val resposta = respostas.stream().filter { r ->
            r.id == id
        }.findFirst().get()
        respostas.remove(resposta)
    }

}