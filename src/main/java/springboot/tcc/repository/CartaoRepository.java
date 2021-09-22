package springboot.tcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springboot.tcc.model.Cartao;

@Repository
@Transactional
public interface CartaoRepository extends CrudRepository<Cartao, Long>{

}
