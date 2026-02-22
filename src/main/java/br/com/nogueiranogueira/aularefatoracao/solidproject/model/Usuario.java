package br.com.nogueiranogueira.aularefatoracao.solidproject.model;

import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.Descontavel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario implements Descontavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
    private int pontos;

    public Usuario(String nome, String email, TipoUsuario tipo) {
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    public Usuario() {}

    @Override
    public int getDesconto() {
        return 0; // desconto padrão para usuários comuns
    }
}