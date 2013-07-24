package dao;

import java.io.Serializable;

import entity.Usuario;

public class UsuarioDao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Inject private Session session;
	
	public boolean existe(Usuario usuario){
		//Session session = HibernateUtil.getSession();
		//session = HibernateUtil.getSession();
//		Criteria c = session.createCriteria(Usuario.class);
//		c.add(Restrictions.ilike("login", usuario.getLogin()));
//		c.add(Restrictions.ilike("senha", usuario.getSenha()));
//		if(c.list().isEmpty())
//			return false;
		return true;
	}
	
//	public static void main(String[] args) {
//		Usuario user = new Usuario();
//		Session session = HibernateUtil.getSession();
//		user.setLogin("admin");
//		user.setSenha("admin");
//		
//		Transaction trans = session.beginTransaction();
//		session.save(user);
//		trans.commit();
//	}

}
