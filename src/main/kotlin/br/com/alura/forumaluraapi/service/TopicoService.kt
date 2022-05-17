package br.com.alura.forumaluraapi.service

import br.com.alura.forumaluraapi.dto.form.TopicoForm
import br.com.alura.forumaluraapi.dto.view.TopicoView
import br.com.alura.forumaluraapi.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: MutableList<Topico> = mutableListOf(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

    fun listar(): List<TopicoView> {
        return this.topicos
            .stream()
            .map { topico ->
                TopicoView(
                    id = topico.id,
                    titulo = topico.titulo,
                    mensagem = topico.mensagem,
                    dataCriacao = topico.dataCriacao,
                    status = topico.status
                )
            }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        return topicos.stream()
            .filter { topico ->
                topico.id == id
            }.findFirst().get()
            .let { topico ->
                TopicoView(
                    id = topico.id,
                    titulo = topico.titulo,
                    mensagem = topico.mensagem,
                    dataCriacao = topico.dataCriacao,
                    status = topico.status
                )
            }
    }

    fun cadastrarTopico(dto: TopicoForm) {
        topicos.add(
            Topico(
                id = topicos.size.toLong() + 1,
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = cursoService.buscarPorId(dto.idCurso), // recupera o objeto Curso que possui o mesmo ID recuperado pelo dto
                autor = usuarioService.buscarPorId(dto.idAutor)
            )
        )
    }

}
