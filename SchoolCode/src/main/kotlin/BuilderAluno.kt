class BuilderAluno {
    lateinit var aluno: Aluno
    fun comNomeCPFeEmail(nome: String, cpf: String, email: String): BuilderAluno {
        aluno = Aluno(nome = nome, cpf = CPF(cpf), email = Email(email))
        return this
    }

    fun criarAluno(): Aluno{
        return this.aluno
    }
}