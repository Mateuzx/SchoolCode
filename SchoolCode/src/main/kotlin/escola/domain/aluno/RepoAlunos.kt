package escola.domain.aluno

// Repo fica sempre na camada de dominio, mas sua implementação fica fora
interface RepoAlunos {

    fun matricular(aluno: Aluno)
    fun buscarPorCPF(cpf: CPF): Aluno
    fun listarAlunosMatriculados(): List<Aluno>

}
