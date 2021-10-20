package springboot.tcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.tcc.model.Cartao;
import springboot.tcc.repository.CartaoRepository;


@Service
public class ServiceCartao {
    
    @Autowired
    private CartaoRepository cartaoRepository; 
    
    
    public ServiceCartao() {
        super();
    }
    
    
    /*
    public List<Cartao> findAll() {
        return cartaoRepository.findAll();
    }*/

    /*
    public void add(final Cartao cartao) {
        this.cartaoRepository.add(cartao);
    }*/
    
}

