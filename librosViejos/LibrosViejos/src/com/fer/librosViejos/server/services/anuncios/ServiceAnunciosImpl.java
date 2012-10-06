/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fer.librosViejos.server.services.anuncios;

import java.util.Collection;
import java.util.List;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.services.anuncios.ServiceAnuncios;
import com.fer.librosViejos.server.persistence.IPersistenceControl;
import com.fer.librosViejos.server.persistence.test.MockPersistenceControl;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ServiceAnunciosImpl extends RemoteServiceServlet implements ServiceAnuncios {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7678788467822072917L;

	IPersistenceControl persistenceControl;
	
	public ServiceAnunciosImpl() {
		super();
		persistenceControl = new MockPersistenceControl();
	}
	
	@Override
	public void createAnuncio(Anuncio book) {
		persistenceControl.createAnuncio(book);
	}

	@Override
	public List<Anuncio> getLibros(String userId) {
		return persistenceControl.getBooksFrom(userId);
	}

	@Override
	public Collection<Anuncio> searchLibros(String searchTerm) {
		return persistenceControl.searchBooks(searchTerm);
	}
}
