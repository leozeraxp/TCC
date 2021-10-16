package springboot.tcc.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springboot.tcc.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	@Query("select u from Usuario u where u.email = :email")
	public Usuario findByEmail(String email);
	
	@Query("select u from Usuario u where u.utilizador = :utilizador and u.senha = :senha")
	public Usuario buscarLogin(String utilizador, String senha);	
}
