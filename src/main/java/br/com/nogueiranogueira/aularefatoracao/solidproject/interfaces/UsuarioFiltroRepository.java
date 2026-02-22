package br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;

import java.util.List;

public interface UsuarioFiltroRepository { // TODO: verificar necessidade
    List<Usuario> buscarPorFiltroAvançados(String nome, String email, TipoUsuario tipoUsuario);
}
