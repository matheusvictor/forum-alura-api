package br.com.alura.forumaluraapi.service

import br.com.alura.forumaluraapi.dto.TopicoDTO
import br.com.alura.forumaluraapi.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: MutableList<Topico> = mutableListOf(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

    fun listar(): List<Topico> {
        return this.topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { topico ->
            topico.id == id
        }.findFirst().get()
    }

    fun cadastrarTopico(dto: TopicoDTO) {
        topicos.add(
            Topico(
                id = topicos.size.toLong() + 1,
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = cursoService.buscarPorId(dto.idCurso),
                autor = usuarioService.buscarPorId(dto.idAutor)
            )
        )
    }

}
