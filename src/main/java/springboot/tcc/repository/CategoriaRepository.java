package springboot.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springboot.tcc.model.Categoria;

@Repository
@Transactional
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	 @Query("select c from Categoria c")
	 public List<Categoria> getCategorias();
}
