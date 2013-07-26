package br.com.unifesp.esfinge.handler;



import java.io.Serializable;

import javax.faces.bean.*;

import br.com.unifesp.esfinge.dao.esfingeData.UsuarioDao;
import br.com.unifesp.esfinge.entity.esfingeData.Usuario;



@SessionScoped
@ManagedBean
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Usuario usuario;
	
	
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
