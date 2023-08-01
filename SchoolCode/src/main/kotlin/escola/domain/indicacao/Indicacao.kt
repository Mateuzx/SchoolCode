package escola.domain.indicacao

import escola.domain.aluno.Aluno
import java.time.LocalDateTime

data class Indicacao(
    var indicado: Aluno,
    var indicante: Aluno,
    var dataIndicacao: LocalDateTime
)
