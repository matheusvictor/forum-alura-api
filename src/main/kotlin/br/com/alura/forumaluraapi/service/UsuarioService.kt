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

        val usuario2 = Usuario(
            id = 2,
            nomeUsuario = "Chico Bento",
            email = "chicobento@email.com"
        )

        usuarios = arrayListOf(usuario, usuario2)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { usuario ->
            usuario.id == id
        }.findFirst().get()
    }

}
