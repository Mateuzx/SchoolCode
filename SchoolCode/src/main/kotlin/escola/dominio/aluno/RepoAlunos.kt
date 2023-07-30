package escola.dominio.aluno

import java.sql.Connection

// Repo fica sempre na camada de dominio, mas sua implementação fica fora
public interface RepoAlunos {

    fun matricular(aluno: Aluno)
    fun buscarPorCPF(cpf: CPF): Aluno
    fun listarAlunosMatriculados(): List<Aluno>


}