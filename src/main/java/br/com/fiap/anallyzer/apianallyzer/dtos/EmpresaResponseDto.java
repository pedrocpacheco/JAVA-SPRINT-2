package br.com.fiap.anallyzer.apianallyzer.dtos;

import br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao.Regiao;

public record EmpresaResponseDto(Long id, CriarEmpresaDto empresa, Regiao regiao){

}
