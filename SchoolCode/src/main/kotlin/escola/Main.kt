package escola

import escola.dominio.aluno.Aluno
import escola.dominio.aluno.BuilderAluno

fun main() {

    val fabrica = BuilderAluno()
    var aluno: Aluno =
        fabrica.comNomeCPFeEmail(nome = "Mateus", "111.222.333-44", "mateus@gmail.com", senha = "mateus123")
            .criarAluno()

    println(aluno)
}