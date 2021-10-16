package springboot.tcc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import springboot.tcc.model.Cartao;
import springboot.tcc.model.Link;
import springboot.tcc.model.Categoria;
import springboot.tcc.model.Usuario;
import springboot.tcc.repository.CartaoRepository;
import springboot.tcc.repository.CategoriaRepository;
import springboot.tcc.repository.UsuarioRepository;

@Controller
public class CartaoController {
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	
	
	/*@JsonIgnoreProperties(ignoreUnknown = true)
	public class LinksList {   
	    List<Link> listaLinks;    

	    public List<Link> getListaLinks() {
	        return listaLinks;
	    }

	    public void setListaLinks(List<Link> listaLinks) {
	        this.listaLinks = listaLinks;
	    } 
	}*/
	
	
	/*public void CreateCover(Response) {
	    Gson gson = new Gson();
	    List<Link> teste = gson.fromJson(response.char, null)
	   System.out.println(coordinates);
	}*/
	
	 public CartaoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/criarcartao", params={"addRow"})
	    public String addRow(final Cartao cartao, final BindingResult bindingResult) {
	        cartao.getLinks().add(new Link());
	        return "criarcartao";
	  }
	
	@GetMapping("/criarcartao")
	public ModelAndView criarCartao() {
		Cartao cartao = new Cartao();
		
		ModelAndView andView = new ModelAndView();
		andView.setViewName("cartao/criarcartao");
		andView.addObject("cartaoobj", cartao);
		andView.addObject("carregarCategorias", categoriaRepository.getCategorias());
		
		
	     cartao.addLink(new Link());
	        
	     cartao.addCategoria(new Categoria());
	        
		return andView;
	}
	
	@PostMapping("**/salvarcartao/{usuarioid}")
	public  ModelAndView salvarCartao(Cartao cartao,@PathVariable("usuarioid") Long usuarioid ) {
		Usuario usuario = usuarioRepository.findById(usuarioid).get();
		cartao.setUsuario(usuario);
		//cartao.setLinks(listaLinks.getListaLinks());
		
		cartaoRepository.save(cartao);
		
		ModelAndView andView = new ModelAndView("cadastro/cadastrocartao");
		andView.setViewName("redirect:/index");
		return andView;	
	}
}
