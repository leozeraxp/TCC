package springboot.tcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import springboot.tcc.model.Cartao;

@Controller
public class CartaoController {

	@GetMapping("/criarcartao")
	public ModelAndView criarCartao() {
		ModelAndView andView = new ModelAndView("cartao/cadastrocartao");
		andView.addObject("cartaoobj", new Cartao());
		return andView;
	}
}
