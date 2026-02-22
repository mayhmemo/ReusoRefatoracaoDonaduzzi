package br.com.nogueiranogueira.aularefatoracao.solidproject.model;

import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.Descontavel;

public class UsuarioVIP implements Descontavel {

    private final Usuario usuario;
    private boolean temCartaoFidelidade;

    public UsuarioVIP(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isTemCartaoFidelidade() {
        return temCartaoFidelidade;
    }

    public void setTemCartaoFidelidade(boolean temCartaoFidelidade) {
        this.temCartaoFidelidade = temCartaoFidelidade;
    }

    @Override
    public int getDesconto() {
        if (!temCartaoFidelidade) {
            return 0; // sem cartão fidelidade, sem desconto
        }
        return 10; // desconto de 10% para usuários VIP
    }
}