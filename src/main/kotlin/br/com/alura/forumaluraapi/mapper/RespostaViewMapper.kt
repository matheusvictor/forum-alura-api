package br.com.alura.forumaluraapi.mapper

import br.com.alura.forumaluraapi.dto.view.RespostaView
import br.com.alura.forumaluraapi.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper : Mapper<Resposta, RespostaView> {

    override fun converte(r: Resposta): RespostaView {
        return RespostaView(
            id = r.id,
            idAutor = r.autor.id!!,
            idTopico = r.topico.id!!,
            mensagem = r.mensagem,
            solucao = r.solucao
        )
    }

}
