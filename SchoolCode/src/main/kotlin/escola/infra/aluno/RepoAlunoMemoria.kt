package escola.infra.aluno

import escola.dominio.aluno.Aluno
import escola.dominio.aluno.CPF
import escola.dominio.aluno.RepoAlunos

class RepoAlunoMemoria : RepoAlunos {

    lateinit var matriculados: MutableList<Aluno>

    override fun matricular(aluno: Aluno) {
        this.matriculados.add(aluno)
    }

    override fun buscarPorCPF(cpf: CPF): Aluno =
        matriculados.find { it.cpf == cpf } ?: throw RuntimeException("AlunoNaoEncontrado($cpf)")


    override fun listarAlunosMatriculados(): List<Aluno> = this.matriculados

}