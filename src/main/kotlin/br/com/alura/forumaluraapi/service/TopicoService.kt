package br.com.alura.forumaluraapi.service

import br.com.alura.forumaluraapi.dto.form.AtualizacaoTopicoForm
import br.com.alura.forumaluraapi.dto.form.TopicoForm
import br.com.alura.forumaluraapi.dto.view.TopicoView
import br.com.alura.forumaluraapi.mapper.TopicoFormMapper
import br.com.alura.forumaluraapi.mapper.TopicoViewMapper
import br.com.alura.forumaluraapi.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: MutableList<Topico> = mutableListOf(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        return this.topicos.stream()
            .map { topico ->
                topicoViewMapper.converte(topico)
            }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        return topicos.stream()
            .filter { topico ->
                topico.id == id
            }.findFirst().get()
            .let { topico ->
                topicoViewMapper.converte(topico)
            }
    }

    fun obterTopico(id: Long): Topico {
        return topicos.stream()
            .filter { topico ->
                topico.id == id
            }.findFirst().get()
    }

    fun cadastrarTopico(formDto: TopicoForm): TopicoView {
        val topico = topicoFormMapper.converte(formDto)
        topico.id = topicos.size.toLong() + 1
        topicos.add(topico)
        return topicoViewMapper.converte(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        topicos.remove(topico) // remove o tópico que será atualizado/substituído
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos.add(topicoAtualizado) // cria um novo Topico e os atributos que não veem do form, permanecem iguais ao do topico capturado
        return topicoViewMapper.converte(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        topicos.remove(topico)
    }

}
