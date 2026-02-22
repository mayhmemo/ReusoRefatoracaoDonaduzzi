package br.com.nogueiranogueira.aularefatoracao.solidproject.components;
import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.IRegraUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class RegraUsuarioAdmin implements IRegraUsuario {

    @Override
    public TipoUsuario tipo() {
        return TipoUsuario.ADMIN;
    }

    @Override
    public Usuario criar(UsuarioDTO dto) {
        validarEmail(dto.email());

        Usuario usuario = new Usuario(dto.nome(), dto.email(), dto.tipo());
        usuario.setPontos(200);
        return usuario;
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }
}
