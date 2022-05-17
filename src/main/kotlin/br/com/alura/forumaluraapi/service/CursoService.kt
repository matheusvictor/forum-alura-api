package br.com.alura.forumaluraapi.service

import br.com.alura.forumaluraapi.model.Curso
import org.springframework.stereotype.Service

@Service
data class CursoService(var cursos: List<Curso>) {

    init {
        val curso = Curso(
            id = 1,
            nomeCurso = "Kotlin",
            categoria = "Programação"
        )
        cursos = arrayListOf(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter { curso ->
            curso.id == id
        }.findFirst().get()
    }

}
