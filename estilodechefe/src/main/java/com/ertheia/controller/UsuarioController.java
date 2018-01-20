package com.ertheia.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ertheia.model.StatusPais;
import com.ertheia.model.StatusPerfil;
import com.ertheia.model.Usuario;
import com.ertheia.repository.Usuarios;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	
	private Facebook facebook;
    private ConnectionRepository connectionRepository;
    private static final String CADASTRO_VIEW = "CadastroUsuario";
    
    @Autowired
	private Usuarios usuarios;
    
    
     
    

    // ACESSAR http://localhost:8080/usuarios/novo	
	@RequestMapping("novo")
	public ModelAndView novo(){	
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Usuario());		
		mv.addObject("todosStatusPerfil", StatusPerfil.values());
		mv.addObject("todosStatusPais", StatusPais.values());
		return mv;
	}
	
	
	//Se existir algum erro de validação no momento de inserir os dados de um novo usuario
	//ele irá retornar para a mesma pagina
	@RequestMapping(method = RequestMethod.POST)
	public String cadastrar(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes ){
			if(errors.hasErrors()){
			return CADASTRO_VIEW;
		}
		
//		System.out.print(">>>>" + usuario.getNome() + usuario.getSobrenome());
		
		try{
		
			usuarios.save(usuario);
			attributes.addFlashAttribute("mensagem","Usuário Registrado com Sucesso!");
			return "redirect:/usuarios/novo";
		
		}catch (DataIntegrityViolationException e) {
			errors.rejectValue("dataVencimento", null, "Formato de data inválido");
			return CADASTRO_VIEW;
		}
			
		
		
	}
	
	//Trocou no modo buscar e colocou o model and view pra passar o nome da view e adicionar tb ao objeto(mv)
	//1° fez a pesquisa em todos os titulos (List)
	//2° adicionei a buscas neste objeto usuarios
	
	
	
	
	//http://localhost:8080/usuarios/buscar
	@RequestMapping("buscar")
	public ModelAndView buscar(){
		List<Usuario>todosUsuarios = usuarios.findAll();
		ModelAndView mv = new ModelAndView("BuscarUsuario");
		mv.addObject("usuarios", todosUsuarios);
		return mv;
	}
	
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Usuario usuario){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW); 
		mv.addObject(usuario);
		return mv;
		
				
	}
	
	//Quando for DELETE, ele irá cair direto no metodo excluir
	//Recebe o codigo para excluir
	//Em seguinda recebendo o codigo (@pathvariable)
	//retornando em ModelAndView (public void excluir para ModelAndView ou String)
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes){
		usuarios.delete(codigo);
		
		attributes.addFlashAttribute("mensagem", "Usuario excluido com sucesso!");
		
		return "redirect:/usuarios/buscar";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@ModelAttribute("todosStatusPais")
	public List<StatusPais>todosStatusPais()
	{
		return Arrays.asList(StatusPais.values());
		
		
	}
	
	@ModelAttribute("todosStatusPerfil")
	public List<StatusPerfil>todosStatusPerfil()
	{
		return Arrays.asList(StatusPerfil.values());
		
		
	}
	
	
	
		
	

}
