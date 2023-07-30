package escola.infra.aluno

import escola.dominio.aluno.*
import java.sql.Connection
import java.sql.SQLException

class RepoAlunoJDBC() : RepoAlunos {

    private lateinit var connection: Connection

    fun RepoAlunoJDBC(connection: Connection) {
        this.connection = connection
    }

    override fun matricular(aluno: Aluno) {
        try {
            var sql = "INSERT INTO ALUNO VALUES (?, ?, ?)"
            var ps = connection.prepareStatement(sql)
            ps.setString(1, aluno.cpf.toString())
            ps.setString(2, aluno.nome)
            ps.setString(3, aluno.email.toString())
            ps.execute()

            sql = "INSERT INTO TELEFONE VALUES (?, ?)"
            ps = connection.prepareStatement(sql)

            for (telefone: Telefone in aluno.telefone) {
                ps.setString(1, telefone.ddd)
                ps.setString(2, telefone.numero)
                ps.execute()
            }
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }

    }

    override fun buscarPorCPF(cpf: CPF): Aluno {
        try {
            val sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?"
            val ps = connection.prepareStatement(sql)
            ps.setString(1, cpf.numero)

            val rs = ps.executeQuery()
            val encontrou = rs.next()
            if (!encontrou) {
                throw RuntimeException("AlunoNaoEncontrado($cpf)")
            }

            val nome = rs.getString("nome")
            val email = Email(rs.getString("email"))
            val encontrado = Aluno(cpf, nome, email)

            val id = rs.getLong("id")
            val telefoneSql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?"
            val psTelefone = connection.prepareStatement(telefoneSql)
            psTelefone.setLong(1, id)
            val rsTelefone = psTelefone.executeQuery()
            while (rsTelefone.next()) {
                val numero = rsTelefone.getString("numero")
                val ddd = rsTelefone.getString("ddd")
                encontrado.adicionarTelefone(ddd, numero)
            }

            return encontrado
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }

    }

    override fun listarAlunosMatriculados(): List<Aluno> {
        return try {
            val sql = "SELECT id, cpf, nome, email FROM ALUNO"
            val ps = connection.prepareStatement(sql)
            val rs = ps.executeQuery()
            val alunos = mutableListOf<Aluno>()
            while (rs.next()) {
                val cpf = CPF(rs.getString("cpf"))
                val nome = rs.getString("nome")
                val email = Email(rs.getString("email"))
                val aluno = Aluno(cpf, nome, email)

                val id = rs.getLong("id")
                val sqlTelefone = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?"
                val psTelefone = connection.prepareStatement(sqlTelefone)
                psTelefone.setLong(1, id)
                val rsTelefone = psTelefone.executeQuery()
                while (rsTelefone.next()) {
                    val numero = rsTelefone.getString("numero")
                    val ddd = rsTelefone.getString("ddd")
                    aluno.adicionarTelefone(ddd, numero)
                }

                alunos.add(aluno)
            }

            alunos
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
    }


}