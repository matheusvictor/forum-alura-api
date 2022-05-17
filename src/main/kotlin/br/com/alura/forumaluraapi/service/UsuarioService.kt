package br.com.alura.forumaluraapi.service

import br.com.alura.forumaluraapi.model.Usuario
import org.springframework.stereotype.Service

@Service
data class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nomeUsuario = "Ana da Silva",
            email = "ana@email.com"
        )
        usuarios = arrayListOf(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { usuario ->
            usuario.id == id
        }.findFirst().get()
    }

}
