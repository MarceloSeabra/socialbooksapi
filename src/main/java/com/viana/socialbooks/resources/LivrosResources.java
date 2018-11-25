/**
 * 
 */
package com.viana.socialbooks.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viana.socialbooks.domain.Livro;
import com.viana.socialbooks.repoitory.LivrosRepository;

/**
 * @author viana
 *
 * @Criado em 24 de nov de 2018
 */
@RestController
@RequestMapping("/livros")
public class LivrosResources {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Livro> listar() {
		
		return livrosRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Livro livro) {
		livrosRepository.save(livro);
		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Optional<Livro> buscar(@PathVariable("id") Long id) {
		return livrosRepository.findById(id);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void deletar(@PathVariable("id") Long id) {
		livrosRepository.deleteById(id);
	}
	
//	//@RequestMapping(value = "/livros", method = RequestMethod.GET,produces = "application/xml")
//	@RequestMapping(value = "/livros", method = RequestMethod.GET)
//	public List<Livro> listar_I() {
//		
//		
//		
//		Livro l1 = new Livro("Rest Aplicado");
//		Livro l2 = new Livro("Git passo-a-passo");
//		Livro[] livros = {l1,l2};
//		
//		return Arrays.asList(livros);
//		
//	}

}