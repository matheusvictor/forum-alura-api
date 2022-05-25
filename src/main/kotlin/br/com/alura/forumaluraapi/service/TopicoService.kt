package br.com.alura.forumaluraapi.service

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

    fun cadastrarTopico(formDto: TopicoForm) {
        val topico = topicoFormMapper.converte(formDto)
        topico.id = topicos.size.toLong() + 1
        topicos.add(topico)
    }

}
