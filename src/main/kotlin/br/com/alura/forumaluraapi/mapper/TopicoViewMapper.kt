package br.com.alura.forumaluraapi.mapper

import br.com.alura.forumaluraapi.dto.view.TopicoView
import br.com.alura.forumaluraapi.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {  // classe responsável por convertar um Topico em TopicoView

    override fun converte(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }

}
