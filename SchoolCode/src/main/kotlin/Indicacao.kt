import java.time.LocalDateTime

data class Indicacao(
    var indicado: Aluno,
    var indicante: Aluno,
    var dataIndicacao: LocalDateTime
){

}
