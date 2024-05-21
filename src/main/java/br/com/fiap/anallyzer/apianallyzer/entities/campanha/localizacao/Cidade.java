package br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "T_CIDADE")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cidade")
	@SequenceGenerator(name = "sq_cidade", sequenceName = "SQ_t_cidade", allocationSize = 1)
	@Column(name = "id_cidade")
	private Long id;
	
	@Column(name = "desc_cidade")
	private String nome;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "id_estado", nullable = false)
	private Estado estado;
	
	@JsonBackReference
	@OneToMany(mappedBy = "cidade")
	private List<Regiao> regioes;
	
}
