package springboot.tcc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springboot.tcc.model.Cartao;
import springboot.tcc.model.Link;
import springboot.tcc.model.Categoria;
import springboot.tcc.model.Usuario;
import springboot.tcc.repository.CartaoRepository;
import springboot.tcc.repository.CategoriaRepository;
import springboot.tcc.repository.UsuarioRepository;


@Controller
@RequestMapping("/cc")
public class CartaoController {
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@ModelAttribute("allCategorias")
    public List<Categoria> populateCategorias() {
        return (List<Categoria>) this.categoriaRepository.findAll();
    }
	
	@RequestMapping(value = "criarcartao")
	public ModelAndView criarCartao(Cartao cartao) {

		ModelAndView andView = new ModelAndView();
		andView.setViewName("cartao/criarcartao");
		andView.addObject("cartao", cartao);
		andView.addObject("carregarCategorias", categoriaRepository.getCategorias());
		
		
	     cartao.addLink(new Link());
	        
	     cartao.addCategoria(new Categoria());
	        
		return andView;
	}
	

	 @RequestMapping(value = "criarcartao", params = {"addOption"})
	 public String addOption(Cartao cartao, BindingResult result) {;
		 cartao.addLink(new Link());
		 return "cartao/criarcartao";
	 }

	 @RequestMapping(value = "criarcartao", method = RequestMethod.POST)
		public  ModelAndView salvarCartao(Cartao cartao,@RequestParam String usuarioid ) {
			Usuario usuario = usuarioRepository.findById(Long.parseLong(usuarioid)).get();
			cartao.setUsuario(usuario);
			System.out.println(usuario+" outrostestee");
			
			cartaoRepository.save(cartao);
			ModelAndView andView = new ModelAndView("cadastro/cadastrocartao");
			andView.setViewName("redirect:/index");
			return andView;	
		}
}
