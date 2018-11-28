/**
 * 
 */
package com.viana.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.viana.socialbooks.domain.Livro;
import com.viana.socialbooks.repoitory.LivrosRepository;
import com.viana.socialbooks.services.exceptions.LivroNaoEncontradoException;

/**
 * @author viana
 *
 * @Criado em 27 de nov de 2018
 */
@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Optional<Livro> buscar(int id) {
		Optional<Livro> livro = livrosRepository.findById(id);
		
		if(livro == null) {
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado.");
		}
		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		livro = livrosRepository.save(livro);
		
		return livro;
	}
	
	public void deletar(Integer id) {
		try {
			livrosRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro nao pode ser encontrado");
		}
	}
	
	public void atualizar(Integer id) {
		
	}

}
