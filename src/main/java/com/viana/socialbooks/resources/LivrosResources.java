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
import com.viana.socialbooks.services.LivrosService;
import com.viana.socialbooks.services.exceptions.LivroNaoEncontradoException;

/**
 * @author viana
 *
 * @Criado em 24 de nov de 2018
 */
@RestController
@RequestMapping("/livros")
public class LivrosResources {

	@Autowired
	private LivrosService livrosService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
		livrosService.salvar(livro);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(livro.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Livro>> buscar(@PathVariable("id") int id) {
		Optional<Livro> livro = null;

		try {
			livro = livrosService.buscar(id);
		} catch (LivroNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(livro);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") int id) {
		try {
			livrosService.deletar(id);
		} catch (LivroNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable("id") int id) {
		livro.setId(id);
		try {
			livrosService.atualizar(livro);
		} catch (LivroNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}

}