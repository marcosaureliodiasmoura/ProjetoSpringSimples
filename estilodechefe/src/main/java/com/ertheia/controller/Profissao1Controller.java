package com.ertheia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ertheia.model.Missao;
import com.ertheia.model.Profissao1;
import com.ertheia.repository.Profissoes1;

//@RestController
//
//@Controller

@RestController
@RequestMapping("/profissoes1")
public class Profissao1Controller {
	

private static final String CADASTRO_VIEW = "CadastrarProfissao1";
    


    @Autowired
	private Profissoes1 profissoes1;
	
    
    @GetMapping("/1id/{id}")
    public Profissao1 buscar(@PathVariable Long id)
    {
    	return profissoes1.findOne(id);
    }
	
    //retornaod um nome apenas
    @GetMapping("1nome/{nome}")
    public Profissao1 buscar(@PathVariable String nome)
    {
    	return profissoes1.findByNome(nome);
    }
    
    @GetMapping("pesquisar/{nome}")
    public List<Profissao1> pesquisarProfissao(@PathVariable ("nome") String nome)
    {
    	return profissoes1.pesquisarProfissao(nome);
    }

    
    	
    @GetMapping
    public List<Profissao1>pesquisar(){
    	return profissoes1.findAll();
    }
    
//    @PostMapping
//    public Profissao1 salvar(@RequestBody Profissao1 profissao1)
//    {
//    	return profissoes1.save(profissao1);
//    }
    
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id)
    {
    	profissoes1.delete(id);
    }
    
    
    @RequestMapping("novo")
	public ModelAndView novo(){	
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Profissao1());
		return mv;
		
	}
	
  //Se existir algum erro de validação no momento de inserir os dados de um novo usuario
  		//ele irá retornar para a mesma pagina
  		@RequestMapping(method = RequestMethod.POST)
  		public String cadastrarProfissao(@Validated Profissao1 profissao1, Errors errors, RedirectAttributes attributes ){
  				if(errors.hasErrors()){
  				return CADASTRO_VIEW;
  			}
  			
//  			System.out.print(">>>>" + usuario.getNome() + usuario.getSobrenome());
  			
  			try{
  			
  				profissoes1.save(profissao1);
  				attributes.addFlashAttribute("mensagem","Profissao Registrada com Sucesso!");
  				return "redirect:/profissoes1/novo";
  			
  			}catch (DataIntegrityViolationException e) {
  				errors.rejectValue("dataVencimento", null, "Formato de data inválido");
  				return CADASTRO_VIEW;
  			}
  			
  		}
  			@RequestMapping("buscar")
  			public ModelAndView buscar(){
  				List<Profissao1>todasProfissoes = profissoes1.findAll();
  				ModelAndView mv = new ModelAndView("BuscarProfissao");
  				mv.addObject("profissoes1", todasProfissoes);
  				return mv;
  			}
	
}