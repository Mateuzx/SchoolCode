package escola.application.indicacao

import escola.domain.aluno.Aluno

interface EnviarEmailIndicacao {

    fun enviarPara(indicado: Aluno)

}
