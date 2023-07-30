package escola

import escola.dominio.aluno.Aluno
import escola.dominio.aluno.BuilderAluno

fun main() {

    val builder = BuilderAluno()
    var aluno: Aluno =
        builder.comNomeCPFeEmail(nome = "Mateus", "111.222.333-44", "mateus@gmail.com")
            .criarAluno()

    println(aluno)
}