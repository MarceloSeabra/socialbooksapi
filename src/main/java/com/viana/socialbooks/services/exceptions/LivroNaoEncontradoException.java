/**
 * 
 */
package com.viana.socialbooks.services.exceptions;

/**
 * @author viana
 *
 * @Criado em 27 de nov de 2018
 */
public class LivroNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7575950640525362151L;

	/**
	 * 
	 */
	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	/**
	 * 
	 */
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	

}
