package br.com.fiap.anallyzer.apianallyzer.entities.ia;

import java.util.List;

import br.com.fiap.anallyzer.apianallyzer.entities.cliente.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "T_RESULTADO_IA")
public class ResultadoIa {
  @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_resultado_ia")
	@SequenceGenerator(name = "sq_resultado_ia", sequenceName = "SQ_t_resultado_ia", allocationSize = 1)
	@Column(name = "id_resultado")
	private Long id;
	
	@OneToMany(mappedBy = "resultado")
	private List<IA> ias;
}
