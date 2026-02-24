package br.com.nogueiranogueira.aularefatoracao.solidproject.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UsuarioVIP extends Usuario {

    private boolean temCartaoFidelidade;

    public UsuarioVIP() {}

    public UsuarioVIP(String nome, String email) {
        super(nome, email, TipoUsuario.VIP);
    }

    @Override
    public int getDesconto() {
        if (!temCartaoFidelidade) {
            return 0; // sem cartão fidelidade, sem desconto
        }
        return 10; // desconto de 10% para usuários VIP
    }
}
