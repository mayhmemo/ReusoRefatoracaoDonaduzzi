package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioValidacaoService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    public void validarEmailNaoCadastrado(String email) {
        long count = usuarioRepository.countByEmail(email);

        if (count > 0) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }
    }

    public void validarIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Usuário deve ser maior de idade");
        }
    }
}