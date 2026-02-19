package br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;

public interface IRegraUsuario {
    String tipo();
    Usuario criar(UsuarioDTO dto);
}
