package springboot.tcc.service;

import java.security.NoSuchAlgorithmException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.tcc.util.Util;
import springboot.tcc.exceptions.CriptoExistsException;
import springboot.tcc.exceptions.EmailExistsException;
import springboot.tcc.model.Usuario;
import springboot.tcc.repository.UsuarioRepository;

@Service
public class ServiceUsuario {
	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	public void salvarUsuario(Usuario usuario) throws Exception{
		try {
			if(usuarioRepository.findByEmail(usuario.getEmail())!= null) {
				throw new EmailExistsException("Já existe um email cadastrado para: "+usuario.getEmail());
			}
			
			usuario.setSenha(Util.md5(usuario.getSenha()));
			
		} catch (NoSuchAlgorithmException e) {
			throw new CriptoExistsException("Erro na criptografia da senha");
		}
		
		usuarioRepository.save(usuario);
	}
	
	public Usuario loginUser(String utilizador, String senha) throws ServiceExcep{
		Usuario userLogin = usuarioRepository.buscarLogin(utilizador, senha);
		
		return userLogin;
	}
}

