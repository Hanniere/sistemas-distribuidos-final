package br.com.unifesp.esfinge.dao;


public class Dao<T> {
	
	private Class<T> persistentClass;
	
	
	public Dao( Class<T> persistentClass){

		this.persistentClass = persistentClass;		
	}
	
	@SuppressWarnings("unchecked")
	
	public void save(T t){


	}
	
	public void delete(T t){


	}
	
	public void atualiza(T t){

	}

}
