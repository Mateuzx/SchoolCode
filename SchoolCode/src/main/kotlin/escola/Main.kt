package escola

import escola.dominio.aluno.Aluno
import escola.dominio.aluno.BuilderAluno

fun main(args: Array<String>) {

    val fabrica = BuilderAluno()
    var aluno: Aluno = fabrica.comNomeCPFeEmail(nome = "Mateus","111.222.333-44", "mateus@gmail.com").criarAluno()

    println(aluno)
}