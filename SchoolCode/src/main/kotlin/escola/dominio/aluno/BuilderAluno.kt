package escola.dominio.aluno

class BuilderAluno {
    lateinit var aluno: Aluno
    fun comNomeCPFeEmail(nome: String, cpf: String, email: String, senha: String): BuilderAluno {
        aluno = Aluno(nome = nome, cpf = CPF(cpf), email = Email(email), senha = senha)
        return this
    }

    fun criarAluno(): Aluno {
        return this.aluno
    }
}