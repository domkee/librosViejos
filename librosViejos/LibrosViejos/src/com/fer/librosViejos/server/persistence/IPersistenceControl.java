package com.fer.librosViejos.server.persistence;

import java.util.Collection;
import java.util.List;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.model.University;
import com.fer.librosViejos.client.model.User;

public interface IPersistenceControl {

	
	public void createAnuncio(Anuncio b);
	
	public void createUser(User user);
	
	public void updateUniversity(String userId, University univ);
	
	public List<Anuncio> getBooksFrom(String userId);
	
	public List<Anuncio> getBooks(List<Long> bookIds);
	
	public List<Anuncio> getBooks(Long... bookIds);
	
	public Collection<Anuncio> searchBooks(String string);
	
}
