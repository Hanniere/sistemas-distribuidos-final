package managedbean;



import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.UsuarioDao;

import entity.Usuario;


@SessionScoped
@Named
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;
	
	@Inject
	private UsuarioDao dao;
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public String efetuaLogin(){
		//UsuarioDao dao = new UsuarioDao();
		boolean loginValido = dao.existe(this.usuario);
		if(loginValido){
			
			return "produto?faces-redirect=true";
		}
		else{
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public boolean isUsuarioLogado(){
		return usuario.getLogin() !=null;
	}

}
