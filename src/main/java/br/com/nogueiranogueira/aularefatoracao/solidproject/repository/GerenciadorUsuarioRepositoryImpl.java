package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.IUsuarioRepository;
import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.UsuarioCrudRepository;
import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.UsuarioFiltroRepository;
import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.UsuarioRelatorioRepository;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GerenciadorUsuarioRepositoryImpl implements UsuarioCrudRepository, UsuarioFiltroRepository, UsuarioRelatorioRepository {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public java.util.List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public void excluir(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public java.util.List<Usuario> buscarPorFiltroAvançados(String nome, String email, TipoUsuario tipoUsuario) {
        // Implementação de busca avançada usando critérios específicos
        throw  new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long contarUsuariosPorTipo(TipoUsuario tipoUsuario) {
        // Implementação de contagem de usuários por tipo
        return usuarioRepository.countByTipo(tipoUsuario);
    }

    @Override
    public java.util.List<Object[]> gerarRelatorioUsuariosPorTipo() {
        // Implementação de geração de relatório de usuários por tipo
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
