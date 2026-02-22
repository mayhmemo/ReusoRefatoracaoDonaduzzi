package br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;

import java.util.List;

public interface UsuarioRelatorioRepository {
    long contarUsuariosPorTipo(TipoUsuario tipoUsuario);
    List<Object[]> gerarRelatorioUsuariosPorTipo();
}
