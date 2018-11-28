/**
 * 
 */
package com.viana.socialbooks.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viana.socialbooks.domain.Livro;

/**
 * @author viana
 *
 * @Criado em 24 de nov de 2018
 */
public interface LivrosRepository extends JpaRepository<Livro, Integer>{
	
	
	

}
