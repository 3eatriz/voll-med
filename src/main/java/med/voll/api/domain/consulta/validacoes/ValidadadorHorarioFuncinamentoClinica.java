package med.voll.api.domain.consulta.validacoes;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadadorHorarioFuncinamentoClinica implements ValidadorAgendamentoDeConsulta{
    
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaClinica = dataConsulta.getHour() < 7;
        var depoisDoFechamentoClinica = dataConsulta.getHour() > 18;

        if(domingo || antesDaAberturaClinica || depoisDoFechamentoClinica){
            throw new ValidacaoException("Consulta fora do horário do funcionamento da clínica");
        }
    }
}
