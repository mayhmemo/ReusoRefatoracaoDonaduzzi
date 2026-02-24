package br.com.nogueiranogueira.aularefatoracao.solidproject.dto;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;

public record UsuarioDTO(
        String nome,
        String email,
        TipoUsuario tipo,
        int idade
) {
}
