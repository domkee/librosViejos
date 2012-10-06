package com.fer.librosViejos.server.persistence.jdbc;

import java.util.Collection;
import java.util.List;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.model.University;
import com.fer.librosViejos.client.model.User;
import com.fer.librosViejos.server.persistence.IPersistenceControl;

public class PersistenceControl implements IPersistenceControl{

	
	
	@Override
	public void createAnuncio(Anuncio b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUniversity(String userId, University univ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Anuncio> getBooksFrom(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Anuncio> getBooks(List<Long> bookIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Anuncio> getBooks(Long... bookIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Anuncio> searchBooks(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
