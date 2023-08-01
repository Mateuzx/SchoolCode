package escola.application.aluno.dtos

import escola.domain.aluno.Aluno
import escola.domain.aluno.CPF
import escola.domain.aluno.Email

data class MatricularAlunoDto(
    var cpfAluno: String,
    var nomeAluno: String,
    var emailAluno: String
) {
    fun criarAluno(): Aluno = Aluno(CPF(cpfAluno), nomeAluno, Email(emailAluno))

}
