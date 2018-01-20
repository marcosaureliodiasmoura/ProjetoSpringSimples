package com.ertheia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ertheia.model.Missao;
import com.ertheia.model.Usuario;
import com.ertheia.repository.Missoes;



@Controller
@RequestMapping("/missoes")
public class MissaoController {
	
private static final String CADASTRO_VIEW = "CadastrarMissao";
    
    @Autowired
	private Missoes missoes;
	
  //tentar dar um find na missao que for do codigo 1 pra advogado, pra chamar todos que possuem advogado como prof
    @RequestMapping(value = "/webservice", method = RequestMethod.GET)
    public ResponseEntity<List<Missao>> listar() {
      return new ResponseEntity<List<Missao>>(new ArrayList<Missao>(missoes.findAll()), HttpStatus.OK);
    }
    
    
	@RequestMapping("novo")
	public ModelAndView novo(){	
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Missao());
		return mv;
		
	}
	
	//Se existir algum erro de validação no momento de inserir os dados de um novo usuario
		//ele irá retornar para a mesma pagina
		@RequestMapping(method = RequestMethod.POST)
		public String cadastrarMissao(@Validated Missao missao, Errors errors, RedirectAttributes attributes ){
				if(errors.hasErrors()){
				return CADASTRO_VIEW;
			}
			
//			System.out.print(">>>>" + usuario.getNome() + usuario.getSobrenome());
			
			try{
			
				missoes.save(missao);
				attributes.addFlashAttribute("mensagem","Missão Registrada com Sucesso!");
				return "redirect:/missoes/novo";
			
			}catch (DataIntegrityViolationException e) {
				errors.rejectValue("dataVencimento", null, "Formato de data inválido");
				return CADASTRO_VIEW;
			}
	
	
		}
		@RequestMapping("buscar")
		public ModelAndView buscar(){
			List<Missao>todasMissoes = missoes.findAll();
			ModelAndView mv = new ModelAndView("BuscarMissao");
			mv.addObject("missoes", todasMissoes);
			return mv;
		}
		
		
	
}