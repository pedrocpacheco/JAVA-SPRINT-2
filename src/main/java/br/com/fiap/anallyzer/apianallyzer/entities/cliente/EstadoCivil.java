package br.com.fiap.anallyzer.apianallyzer.entities.cliente;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "T_ESTADO_CIVIL")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCivil {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_estado_civil")
	@SequenceGenerator(name = "sq_estado_civil", sequenceName = "SQ_t_estado_civil", allocationSize = 1)
	@Column(name = "id_est_civ")
	private Long id;
	
	@OneToMany(mappedBy = "estadoCivil")
	private List<Cliente> clientes;
}
