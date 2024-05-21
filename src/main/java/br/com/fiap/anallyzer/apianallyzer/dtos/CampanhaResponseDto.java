package br.com.fiap.anallyzer.apianallyzer.dtos;

import br.com.fiap.anallyzer.apianallyzer.entities.campanha.Empresa;
import br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao.Regiao;

public record CampanhaResponseDto(Long id, CriarCampanhaDto campanha, Empresa empresa, Regiao regiao) {

}
