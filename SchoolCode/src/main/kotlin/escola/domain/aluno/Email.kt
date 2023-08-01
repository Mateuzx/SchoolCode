package escola.domain.aluno

// VALUE OBJECT
data class Email(
    var endereco_email: String
) {
    init {
        endereco_email = endereco_email.replace("\\s+".toRegex(), "")
        when (endereco_email.contains("@")) {
            true -> endereco_email
            false -> throw IllegalArgumentException("Esse não é um email válido")
        }
    }
}
