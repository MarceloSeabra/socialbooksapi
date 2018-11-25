/**
 * 
 */
package com.viana.socialbooks.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
		livrosRepository.save(livro);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id").buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<Livro>> buscar(@PathVariable("id") Long id) {
		
		Optional<Livro> livro = livrosRepository.findById(id);
		if(!livro.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
		
		return ResponseEntity.status(HttpStatus.OK).body(livro);
		}
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void deletar(@PathVariable("id") Long id) {
		livrosRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void atualizar(@RequestBody Livro livro, @PathVariable("id") Long id) {
		livro.setId(id);
		livrosRepository.save(livro);
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