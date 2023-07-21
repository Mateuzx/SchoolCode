package escola.dominio.indicacao

import escola.dominio.aluno.Aluno
import java.time.LocalDateTime

data class Indicacao(
    var indicado: Aluno,
    var indicante: Aluno,
    var dataIndicacao: LocalDateTime
){

}
