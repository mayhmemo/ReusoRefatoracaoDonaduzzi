package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.IRegraUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.TipoUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GerenciadorUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMailSenderService usuarioMailSenderService;

    private final Map<TipoUsuario, IRegraUsuario> regrasPorTipo;

    public GerenciadorUsuarioService(List<IRegraUsuario> regras) {
        this.regrasPorTipo = regras.stream()
                .collect(Collectors.toMap(IRegraUsuario::tipo, Function.identity()));
    }

    public Usuario criarUsuario(UsuarioDTO dto) {
        IRegraUsuario regra = regrasPorTipo.get(dto.tipo());

        if (regra == null) {
            throw new IllegalArgumentException("Tipo inválido: " + dto.tipo());
        }

        Usuario usuarioEntidade = regra.criar(dto);
        Usuario usuarioSalvo = usuarioRepository.save(usuarioEntidade);

        usuarioMailSenderService.enviarEmailBoasVindas(usuarioSalvo.getEmail(), usuarioSalvo.getNome());

        return usuarioSalvo;
    }
}