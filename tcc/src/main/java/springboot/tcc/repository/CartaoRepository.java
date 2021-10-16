package springboot.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springboot.tcc.model.Cartao;

@Repository
@Transactional
public interface CartaoRepository extends CrudRepository<Cartao, Long>{
	@Query("select c from Cartao c where c.usuario.id = ?1")
	List<Cartao> findCartaoById(Long idpesquisa);
}
