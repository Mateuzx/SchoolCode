package escola.application.aluno.matricular

import escola.application.aluno.dtos.MatricularAlunoDto
import escola.domain.aluno.RepoAlunos

class MatricularAluno(private var repositorio: RepoAlunos) {

    fun executa(dados: MatricularAlunoDto) {
        val novo = dados.criarAluno()
        repositorio.matricular(novo)
    }

}
