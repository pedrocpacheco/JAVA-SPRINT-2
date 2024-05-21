package br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "T_ESTADO")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_estado")
	@SequenceGenerator(name = "sq_estado", sequenceName = "SQ_t_estado", allocationSize = 1)
	@Column(name = "id_estado")
	private Long id;
	
	@Column(name = "desc_estado")
	private String nome;
	
	@ManyToOne()
	@JoinColumn(name = "id_pais", nullable = false)
	private Pais pais;
	
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades;
}
