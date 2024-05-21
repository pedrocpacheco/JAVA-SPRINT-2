package br.com.fiap.anallyzer.apianallyzer.entities.ia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "T_IA")
public class IA {
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_ia")
	@SequenceGenerator(name = "sq_ia", sequenceName = "SQ_t_ia", allocationSize = 1)
  @Column(name = "id_ia")
  private Long id;

  @ManyToOne()
	@JoinColumn(name = "id_resultado", nullable = false)
  private ResultadoIa resultado;

  @ManyToOne()
	@JoinColumn(name = "id_empresa", nullable = false)
  private ResultadoIa empresa;

  @ManyToOne()
	@JoinColumn(name = "ia_campanha", nullable = false)
  private ResultadoIa campanha;

  @Column(name = "descricao_ia")
  private String descricao;

}
