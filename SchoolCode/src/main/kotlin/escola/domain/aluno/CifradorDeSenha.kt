package escola.domain.aluno

interface CifradorDeSenha {

    fun cifrarSenha(senha: String): String
    fun validarSenhaCifrada(senhaCifrada: String, senhaAberta: String): Boolean

}
