package escola.dominio.aluno

data class Aluno(
    var cpf: CPF,
    var nome: String,
    var email: Email,
    var telefone: MutableList<Telefone>
) {

    constructor(cpf: CPF, nome: String, email: Email) : this(cpf, nome, email, mutableListOf())


    fun adicionarTelefone(ddd: String, numero: String) {
        telefone.add(Telefone(ddd, numero))
    }

}