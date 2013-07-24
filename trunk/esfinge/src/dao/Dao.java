package dao;

import org.jboss.logging.Logger;

public class Dao<T> {
	private static Logger logger = Logger.getLogger(Dao.class);
	private Class<T> persistentClass;
	
	
	public Dao( Class<T> persistentClass){

		this.persistentClass = persistentClass;		
	}
	
	@SuppressWarnings("unchecked")
	
	public void save(T t){
		logger.info("salvando "+ t);

	}
	
	public void delete(T t){
		logger.info("removendo "+t);

	}
	
	public void atualiza(T t){

	}

}
