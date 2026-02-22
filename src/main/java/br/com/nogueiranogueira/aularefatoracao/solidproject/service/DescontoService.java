package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.interfaces.Descontavel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescontoService {
    public int calculaDescontoTotal(List<Descontavel> usuarios) {
        return usuarios.stream()
                .mapToInt(Descontavel::getDesconto)
                .sum();
    }
}