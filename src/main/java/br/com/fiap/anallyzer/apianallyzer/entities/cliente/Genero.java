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
@Table(name = "T_GENERO")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_genero")
	@SequenceGenerator(name = "sq_genero", sequenceName = "SQ_t_genero", allocationSize = 1)
	@Column(name = "id_genero")
	private Long id;
	
	@OneToMany(mappedBy = "genero")
	private List<Cliente> clientes;
}
