package br.com.fiap.anallyzer.apianallyzer.entities.cliente;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.fiap.anallyzer.apianallyzer.dtos.CriarClienteDto;
import br.com.fiap.anallyzer.apianallyzer.entities.campanha.Campanha;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "T_CLIENTE")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
	@SequenceGenerator(name = "sq_cliente", sequenceName = "SQ_t_cliente", allocationSize = 1)
	@Column(name = "id_cliente")
	private Long id;
	
	@Column(name = "nm_cliente")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "dt_nascimento")
	private LocalDate dtNascimento;

	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name = "id_campanha", nullable = false)
	private Campanha campanha;
	
	// Relacionadas apenas a Cliente
	@ManyToOne()
	@JoinColumn(name = "id_genero", nullable = false)
	private Genero genero;
	
	@ManyToOne()
	@JoinColumn(name = "id_est_civ", nullable = false)
	private EstadoCivil estadoCivil;
	
	@ManyToOne()
	@JoinColumn(name = "id_escolaridade", nullable = false)
	private Escolaridade escolaridade;
	
	
	public Cliente(CriarClienteDto clienteDto, Genero genero, EstadoCivil estadoCivil, Escolaridade escolaridade, Campanha campanha) {
		this.nome = clienteDto.nome();
		this.email = clienteDto.email();
		this.dtNascimento = clienteDto.dtNascimento();
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.escolaridade = escolaridade;
		this.campanha = campanha;
	}
}
