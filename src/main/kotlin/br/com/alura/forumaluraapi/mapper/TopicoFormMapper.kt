package br.com.alura.forumaluraapi.mapper

import org.springframework.stereotype.Component
import br.com.alura.forumaluraapi.model.Topico
import br.com.alura.forumaluraapi.dto.form.TopicoForm
import br.com.alura.forumaluraapi.service.CursoService
import br.com.alura.forumaluraapi.service.UsuarioService

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) : Mapper<TopicoForm, Topico> {

    override fun converte(t: TopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso), // recupera o objeto Curso que possui o mesmo ID recuperado pelo dto
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}
