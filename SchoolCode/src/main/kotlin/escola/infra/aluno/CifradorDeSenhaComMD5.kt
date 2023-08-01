package escola.infra.aluno

import escola.domain.aluno.CifradorDeSenha
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class CifradorDeSenhaComMD5 : CifradorDeSenha {
    override fun cifrarSenha(senha: String): String {
        try {
            val md = MessageDigest.getInstance("MD5")
            md.update(senha.toByteArray())
            val bytes = md.digest()
            val sb = StringBuilder()
            for (i in bytes.indices) {
                sb.append(Integer.toString((bytes[i].toInt() and 0xff) + 0x100, 16).substring(1))
            }
            return sb.toString()
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("erro ao gerar hash da senha")
        }
    }

    override fun validarSenhaCifrada(senhaCifrada: String, senhaAberta: String): Boolean {
        return senhaCifrada == cifrarSenha(senhaAberta)
    }

}
