package escola.aplicacao.indicacao

import escola.dominio.aluno.Aluno

interface EnviarEmailIndicacao {

    fun enviarPara(indicado: Aluno)

}