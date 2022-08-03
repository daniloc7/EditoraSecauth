package dw.editora.control;

import java.util.ArrayList;
import org.springframework.security.core.Authentication;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;

import dw.editora.model.Artigo;
import dw.editora.repository.ArtigoRepository;

@RestController
public class ArtigoController {

	@Autowired
	ArtigoRepository rep;
	
	//LISTA TODOS ARTIGOS
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value="/listarartigos")
	public ModelAndView pessoas() {
		ModelAndView mv = new ModelAndView("artigos/home");
		Iterable<Artigo> artigoIt = rep.findAll();
		mv.addObject("artigos", artigoIt);
		mv.addObject("artigoobj", new Artigo());//add por ult
		return mv;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value="/pesquisarartigo")
	public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa){
		ModelAndView mv = new ModelAndView("artigos/home");
		mv.addObject("artigos", rep.findByTituloContaining(nomepesquisa));
		mv.addObject("artigoobj", new Artigo());
		
		return mv;
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value="**/salvarartigo")
	public ModelAndView createArtigo(Artigo ar) {
			ModelAndView mv = new ModelAndView("artigos/cadastro");
			rep.save(ar);
			mv.addObject("artigoobj", new Artigo());//add por ult
			return mv;
			
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value="/updateartigo/{id}")
	public ModelAndView updateArtigo(@PathVariable("id") Long id) {
//		long idL = Long.parseLong(id);
		Optional<Artigo> artigo = rep.findById(id);
		
		ModelAndView mv = new ModelAndView("artigos/editar");
		mv.addObject("artigoobj", artigo.get());
		mv.addObject("artigoobj", new Artigo());//add por ult
		return mv;
	}
	
	@GetMapping("/removerartigo/{id}")
	public ModelAndView excluirArtigo(@PathVariable("id") long id) {
		
		rep.deleteById(id);
		ModelAndView mv = new ModelAndView("artigos/home");
		mv.addObject("artigos", rep.findAll());
		mv.addObject("artigoobj", new Artigo());//add por ult
		return mv;
	}
	
	@GetMapping("/removertudo")
	public ModelAndView remover() {
		
		rep.deleteAll();
		ModelAndView mv = new ModelAndView("artigos/home");
		mv.addObject("artigos", rep.findAll());
		mv.addObject("artigoobj", new Artigo());//add por ult
		return mv;
	}
}
