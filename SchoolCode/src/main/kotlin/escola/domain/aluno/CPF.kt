package escola.domain.aluno

data class CPF(
    val numero: String
) {
    init {
        if (!numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}".toRegex())) {
            throw IllegalArgumentException("CPF inválido")
        }
    }
}
