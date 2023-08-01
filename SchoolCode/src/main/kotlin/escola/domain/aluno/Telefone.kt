package escola.domain.aluno

data class Telefone(
    val ddd: String,
    val numero: String
) {
    init {
        if (!ddd.matches("\\d{2}".toRegex())) {
            throw IllegalArgumentException("DDD inválido!")
        }

        if (!numero.matches("\\d{8}|\\d{9}".toRegex())) {
            throw IllegalArgumentException("Número inválido!")
        }
    }
}
