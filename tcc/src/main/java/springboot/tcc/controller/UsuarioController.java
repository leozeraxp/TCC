package springboot.tcc.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import springboot.tcc.util.Util;
import springboot.tcc.model.Cartao;
import springboot.tcc.model.Usuario;
import springboot.tcc.repository.CartaoRepository;
import springboot.tcc.service.ServiceExcep;
//import springboot.tcc.repository.UsuarioRepository;
import springboot.tcc.service.ServiceUsuario;

@Controller
public class UsuarioController {
	/*@Autowired
	private UsuarioRepository usuarioRepository;*/
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@GetMapping("index")
	public ModelAndView index() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("index");
		andView.addObject("usuario", new Usuario());
		return andView;
	}
	
	@GetMapping("/cadastrousuario")
	public ModelAndView cadastroUsuario() {
		ModelAndView andView = new ModelAndView("usuario/cadastrousuario");
		andView.addObject("usuarioobj", new Usuario());
		return andView;
	}
	
	@PostMapping("**/salvarusuario")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult bindingResult) throws Exception {
		ModelAndView andView = new ModelAndView("usuario/cadastrousuario");
		if(bindingResult.hasErrors()) {
			andView.addObject("usuarioobj", new Usuario());
			
			List<String> msg = new ArrayList<String>();
			for(ObjectError objectError : bindingResult.getAllErrors()) {
				msg.add(objectError.getDefaultMessage());
			}
			
			andView.addObject("msg",msg);
			return andView;
		}else {		
		serviceUsuario.salvarUsuario(usuario);
		
		andView.setViewName("redirect:/login");
		return andView;
		}
	}
	
	@GetMapping("/logar")
	public ModelAndView logar() {
		ModelAndView andView = new ModelAndView("login/login");
		//andView.setViewName("login/login");
		andView.addObject("usuario", new Usuario());
		return andView;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult bindingResult, HttpSession session) throws NoSuchAlgorithmException, ServiceExcep {
		ModelAndView andView = new ModelAndView();
		andView.addObject("usuario", new Usuario());
		if(bindingResult.hasErrors()) {
			andView.setViewName("login/login");
		}
		
		Usuario userLogin = serviceUsuario.loginUser(usuario.getUtilizador(), Util.md5(usuario.getSenha()));
		if(userLogin == null) {
			andView.addObject("msg","Usuário não encontrado. Tente novamente");
		}else {
			session.setAttribute("usuarioLogado", userLogin);		
			return index();
		}
		return andView;
	}
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return logar();
	}
	
	@GetMapping("/exibirperfil/{idusuario}")
	public ModelAndView perfilUsuario(@PathVariable("idusuario") Long idusuario) {
		//Optional<Cartao> cartao = cartaoRepository.findById(idusuario);
		System.out.println(idusuario);
		ModelAndView andView = new ModelAndView("usuario/exibirperfil");
		andView.addObject("cartoes", cartaoRepository.findCartaoById(idusuario));
		return andView;
	}
}
