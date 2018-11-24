/**
 * 
 */
package com.viana.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class LivrosResources {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar() {
		
		return livrosRepository.findAll();
		
		/*
		Livro l1 = new Livro("Rest Aplicado");
		Livro l2 = new Livro("Git passo-a-passo");
		Livro[] livros = {l1,l2};
		
		return Arrays.asList(livros);
		*/
	}

}