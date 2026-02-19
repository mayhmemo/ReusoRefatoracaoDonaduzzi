package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.IUsuarioRepository;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMailSenderService usuarioMailSenderService;

    public Usuario criarUsuario(Usuario usuario) {
        String tipo = usuario.getTipo();

        validarUsuarioJaExistente(usuario.getEmail());

        if ("COMUM".equals(tipo)) {
            validarEmail(usuario.getEmail());
            usuario.setPontos(0);

        } else if ("VIP".equals(tipo)) {
            validarEmail(usuario.getEmail());
            usuario.setPontos(100);

        } else {
            throw new IllegalArgumentException("Tipo inválido");
        }

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        usuarioMailSenderService.enviarEmailBoasVindas(usuario.getEmail(), usuario.getNome());

        return usuarioSalvo;
    }

    private void validarUsuarioJaExistente(String email){
        long count = usuarioRepository.countByEmail(email);

        if (count > 0) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }
}
