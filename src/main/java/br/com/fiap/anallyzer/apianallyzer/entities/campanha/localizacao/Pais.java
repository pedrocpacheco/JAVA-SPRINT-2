package br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao;

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
@Table(name = "T_PAIS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pais")
	@SequenceGenerator(name = "sq_pais", sequenceName = "SQ_t_pais", allocationSize = 1)
	@Column(name = "id_pais")
	private Long id;
	
	@Column(name = "desc_pais")
	private String nome;
	
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados;
}
