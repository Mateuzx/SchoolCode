package escola.dominio.aluno

interface CifradorDeSenha {

    fun cifrarSenha(senha: String): String
    fun validarSenhaCifrada(senhaCifrada: String, senhaAberta: String): Boolean

}