package br.com.alura.forumaluraapi.mapper

import br.com.alura.forumaluraapi.dto.form.RespostaForm
import br.com.alura.forumaluraapi.model.*
import org.springframework.stereotype.Component
import br.com.alura.forumaluraapi.service.TopicoService
import br.com.alura.forumaluraapi.service.UsuarioService

@Component
class RespostaFormMapper(
    private val usuarioService: UsuarioService,
    private val topicoService: TopicoService,
) : Mapper<RespostaForm, Resposta> {

    override fun converte(r: RespostaForm): Resposta {
        return Resposta(
            mensagem = r.mensagem,
            autor = usuarioService.buscarPorId(r.idAutor),
            topico = topicoService.obterTopico(r.idTopico),
            solucao = r.solucao
        )
    }

}
