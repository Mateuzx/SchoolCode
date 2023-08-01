package escola.infra.aluno

import escola.domain.aluno.Aluno
import escola.domain.aluno.CPF
import escola.domain.aluno.RepoAlunos

class RepoAlunoMemoria : RepoAlunos {

    private lateinit var matriculados: MutableList<Aluno>

    override fun matricular(aluno: Aluno) {
        this.matriculados.add(aluno)
    }

    override fun buscarPorCPF(cpf: CPF): Aluno =
        matriculados.find { it.cpf == cpf } ?: throw RuntimeException("AlunoNaoEncontrado($cpf)")


    override fun listarAlunosMatriculados(): List<Aluno> = this.matriculados

}
