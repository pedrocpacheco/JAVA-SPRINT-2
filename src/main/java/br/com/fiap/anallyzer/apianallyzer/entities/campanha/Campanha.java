package br.com.fiap.anallyzer.apianallyzer.entities.campanha;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao.Regiao;
import br.com.fiap.anallyzer.apianallyzer.entities.cliente.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "T_CAMPANHA")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Campanha {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_campanha")
	@SequenceGenerator(name = "sq_campanha", sequenceName = "SQ_t_campanha", allocationSize = 1)
	@Column(name = "id_campanha")
	private Long id;
	
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@CreatedDate
	@Column(name = "data", nullable = true)
	private Date dtCampanha;
	
	@JsonBackReference
	@OneToMany(mappedBy = "campanha")
	private List<Cliente> clientes;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "id_regiao", nullable = false)
	private Regiao regiao;
	
	public Campanha(String titulo, String descricao, Empresa empresa, Regiao regiao) {
		this.descricao = descricao;
		this.titulo = titulo;
		this.empresa = empresa;
		this.regiao = regiao;
	}
}
