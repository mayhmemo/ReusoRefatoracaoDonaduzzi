package br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IGerenciadorUsuarioRepository {

    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorId(Long id);
    List<Usuario> buscarTodos();
    void excluir(Usuario usuario);

    List<Usuario> buscarPorFiltroAvançados(String nome, String email, TipoUsuario tipoUsuario);
    long contarUsuariosPorTipo(TipoUsuario tipoUsuario);
    List<Object[]> gerarRelatorioUsuariosPorTipo();
}