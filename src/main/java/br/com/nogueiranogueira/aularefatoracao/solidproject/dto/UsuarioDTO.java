package br.com.nogueiranogueira.aularefatoracao.solidproject.dto;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        TipoUsuario tipo,
        int idade
) {
}
