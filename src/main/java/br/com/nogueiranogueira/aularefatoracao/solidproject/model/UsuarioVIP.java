package br.com.nogueiranogueira.aularefatoracao.solidproject.model;

import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.Descontavel;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UsuarioVIP implements Descontavel {

    private final Usuario usuario;
    @Setter
    private boolean temCartaoFidelidade;

    public UsuarioVIP(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int getDesconto() {
        if (!temCartaoFidelidade) {
            return 0; // sem cartão fidelidade, sem desconto
        }
        return 10; // desconto de 10% para usuários VIP
    }
}