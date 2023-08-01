package escola.application

import escola.application.aluno.matricular.MatricularAluno
import escola.application.aluno.dtos.MatricularAlunoDto
import escola.infra.aluno.RepoAlunoMemoria

class MatricularAlunoLinhaComando {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var nome: String = "Mateus"
            var cpf: String = "123.456.789-00"
            var email: String = "mateus@gmail.com"

            var matricular = MatricularAluno(RepoAlunoMemoria())
            matricular.executa(MatricularAlunoDto(nomeAluno = nome, cpfAluno = cpf, emailAluno = email))
        }
    }

}
