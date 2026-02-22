package br.com.nogueiranogueira.aularefatoracao.solidproject.components;
import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.IRegraUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.service.UsuarioValidacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegraUsuarioVip implements IRegraUsuario {

    @Autowired
    private UsuarioValidacaoService usuarioValidacaoService;

    @Override
    public TipoUsuario tipo() {
        return TipoUsuario.VIP;
    }

    @Override
    public Usuario criar(UsuarioDTO dto) {
        usuarioValidacaoService.validarEmail(dto.email());
        usuarioValidacaoService.validarIdade(dto.idade());
        usuarioValidacaoService.validarEmailNaoCadastrado(dto.email());

        Usuario usuario = new Usuario(dto.nome(), dto.email(), dto.tipo());
        usuario.setPontos(100);
        return usuario;
    }
}