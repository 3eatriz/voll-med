package med.voll.api.domain.consulta;

import java.time.LocalDate;

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDate data) {
    
}
