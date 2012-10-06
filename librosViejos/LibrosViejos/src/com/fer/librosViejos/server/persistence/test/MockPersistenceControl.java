package com.fer.librosViejos.server.persistence.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.model.TipoAnuncio;
import com.fer.librosViejos.client.model.University;
import com.fer.librosViejos.client.model.User;
import com.fer.librosViejos.server.persistence.IPersistenceControl;

public class MockPersistenceControl implements IPersistenceControl {

	private static Map<String,Anuncio> books = new HashMap<String,Anuncio>();
	private static Map<String,User> users = new HashMap<String,User>();
	static int booksId = 0;
	
	public MockPersistenceControl() {
		createAnuncio(new Anuncio().init("libro libro libro libro libro libro libro libro libro libro", "81723yasd", "descripcion descripcion descripcion descripcion descripcion", 20500,TipoAnuncio.libro));
		createAnuncio(new Anuncio().init("libro libro libro libro libro libro libro libro libro libro", "81723yasd", "descripcion descripcion descripcion descripcion descripcion", 20500,TipoAnuncio.libro));
		createAnuncio(new Anuncio().init("libro libro libro libro libro libro libro libro libro libro", "81723yasd", "descripcion descripcion descripcion descripcion descripcion", 20500,TipoAnuncio.libro));
		createAnuncio(new Anuncio().init("libro libro libro libro libro libro libro libro libro libro", "81723yasd", "descripcion descripcion descripcion descripcion descripcion", 20500,TipoAnuncio.libro));
		createAnuncio(new Anuncio().init("libro libro libro libro libro libro libro libro libro libro", "81723yasd", "descripcion descripcion descripcion descripcion descripcion", 20500,TipoAnuncio.libro));
		createAnuncio(new Anuncio().init("libro libro libro libro libro libro libro libro libro libro", "81723yasd", "descripcion descripcion descripcion descripcion descripcion", 20500,TipoAnuncio.libro));
		createAnuncio(new Anuncio().init("libro libro libro libro libro libro libro libro libro libro", "81723yasd", "descripcion descripcion descripcion descripcion descripcion", 20500,TipoAnuncio.libro));
	
	}
	
	@Override
	public void createAnuncio(Anuncio b) {
		booksId++;
		books.put(""+booksId, b);
	}

	@Override
	public void createUser(User user) {
		users.put(user.getId(), user);
	}

	@Override
	public void updateUniversity(String userId, University univ) {
		User u = users.get(userId);
		u.setUniversity(univ);
		users.put(userId, u);
	}

	@Override
	public List<Anuncio> getBooksFrom(String userId) {
		List<Anuncio>  answ = new ArrayList<Anuncio>();
		for (Anuncio b : books.values()) {
			if (b.getOwner().equals(userId))
			{
				answ.add(b);
			}
		}
		return answ;
	}

	@Override
	public List<Anuncio> getBooks(List<Long> bookIds) {
		List<Anuncio>  answ = new ArrayList<Anuncio>();
		for (Anuncio b : books.values()) {
			if (bookIds.contains(b.getId()))
			{
				answ.add(b);
			}
		}

		return answ;
		
	}

	@Override
	public List<Anuncio> getBooks(Long... bookIds) {
		List<Long> books = Arrays.asList(bookIds);
		return getBooks(books);
	}

	@Override
	public Collection<Anuncio> searchBooks(String string) {
		Collection<Anuncio> answ = new ArrayList<Anuncio>(books.values());
		return answ;
	}

}
