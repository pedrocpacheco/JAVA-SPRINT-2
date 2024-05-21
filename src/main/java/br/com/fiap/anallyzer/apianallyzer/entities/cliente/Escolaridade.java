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
@Table(name = "T_ESCOLARIDADE")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Escolaridade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_escolaridade")
	@SequenceGenerator(name = "sq_escolaridade", sequenceName = "SQ_t_escolaridade", allocationSize = 1)
	@Column(name = "id_escolaridade")
	private Long id;
	
	@OneToMany(mappedBy = "escolaridade")
	private List<Cliente> clientes;
}
