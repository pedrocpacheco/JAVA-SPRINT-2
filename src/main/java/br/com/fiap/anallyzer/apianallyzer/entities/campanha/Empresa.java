package br.com.fiap.anallyzer.apianallyzer.entities.campanha;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao.Regiao;
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
@Table(name = "T_EMPRESA")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_empresa")
	@SequenceGenerator(name = "sq_empresa", sequenceName = "SQ_t_empresa", allocationSize = 1)
	@Column(name = "id_empresa")
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	
	@Column(name = "contato", nullable = false)
	private String contato;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "id_regiao", nullable = false)
	private Regiao regiao;
	
	@JsonBackReference
	@OneToMany(mappedBy = "empresa")
	private List<Campanha> campanhas;
	
	public Empresa(String nome, String cnpj, String contato, Regiao regiao) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.contato = contato;
		this.regiao = regiao;
	}
}
