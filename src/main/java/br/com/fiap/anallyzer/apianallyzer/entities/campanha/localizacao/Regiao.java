package br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.fiap.anallyzer.apianallyzer.entities.campanha.Campanha;
import br.com.fiap.anallyzer.apianallyzer.entities.campanha.Empresa;
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
@Table(name = "T_REGIAO")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Regiao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_regiao")
	@SequenceGenerator(name = "sq_regiao", sequenceName = "SQ_t_regiao", allocationSize = 1)
	@Column(name = "id_regiao")
	private Long id;
	
	@Column(name = "desc_regiao")
	private String nome;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name = "id_cidade", nullable = false)
	private Cidade cidade;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "regiao")
	private List<Campanha> campanhas;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "regiao")
	private List<Empresa> empresas;
}
