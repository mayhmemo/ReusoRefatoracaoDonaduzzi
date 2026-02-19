package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMailSenderService {

    @Autowired
    private SmtpEmailService smtpEmailService;

    public void enviarEmailBoasVindas(String email, String nomeUsuario) {
        String assunto = "Bem-vindo ao nosso sistema!";
        String mensagem = "Olá, " + nomeUsuario + ", seu cadastro foi realizado com sucesso.";
        smtpEmailService.sendEmail(email, assunto, mensagem);
    }
}
