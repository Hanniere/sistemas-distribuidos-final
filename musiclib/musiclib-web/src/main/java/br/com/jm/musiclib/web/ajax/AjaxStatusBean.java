package br.com.jm.musiclib.web.ajax;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jm.musiclib.web.StatusBean;

/**
 * Bean respons�vel por monitorar o andamento da indexa��o e atualizar o status
 * para o usu�rio. Verifica o bean StatusBean para obter as informa��es.
 * 
 * 
 * @see StatusBean
 * 
 */
@Named(value = "ajaxStatusBean")
@SessionScoped
public class AjaxStatusBean implements Serializable {
  /** Log */
  private Logger log = Logger.getLogger("br.com.jm.musiclib.web");

  /**
   * 
   */
  private static final long serialVersionUID = -2461648661629070947L;

  /**
   * StatusBean injetado pelo container.
   */
  @Inject
  private StatusBean bean;
  /** Assunto da quest�o indexada */
  private String assunto;
  /** Institui��o da quest�o indexada */
  private String instituicao;
  /** Autor da quest�o indexada */
  private String autor;
  /** Nome do arquivo da quest�o indexada */
  private String fileName;
  /** N�mero da quest�o indexada */
  private String postagemNumber;

  /**
   * Atualiza o status dos campos de acordo com o estado do bean StatusBean.
   * Esse m�todo deve ser invocado pela p�gina que ir� exibir o estado da
   * indexa��o.
   * 
   * Quando a indexa��o � finalizada, o fluxo � redirecionado para a p�gina
   * main.
   * 
   * @see StatusBean
   * @see StatusBean#getCompleted()
   */
  public void updateStatus() {
    if (bean == null) {
      setAssunto("");
      setInstituicao("");
      setAutor("");
      setFileName("");
      setPostagemNumber("");
    } else {
      if (bean.getCompleted()) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          context.getExternalContext().redirect("main.jsf");
          //context.getExternalContext().redirect("main.jsf");
        } catch (IOException e) {
          log.throwing("AjaxStatusBean", "updateStatus", e);
        }
      } else {
        setAssunto(bean.getAssunto());
        setInstituicao(bean.getInstituicao());
        setAutor(bean.getAutor());
        setFileName(bean.getFileName());
        setPostagemNumber(bean.getPostagemNumber());
      }
    }
  }

  /**
   * @return the log
   */
  public Logger getLog() {
    return log;
  }

  /**
   * @param log
   *            the log to set
   */
  public void setLog(Logger log) {
    this.log = log;
  }

  /**
   * @return the bean
   */
  public StatusBean getBean() {
    return bean;
  }

  /**
   * @param bean
   *            the bean to set
   */
  public void setBean(StatusBean bean) {
    this.bean = bean;
  }

  /**
   * @return the assunto
   */
  public String getAssunto() {
    return assunto;
  }

  /**
   * @param assunto
   *            the assunto to set
   */
  public void setAssunto(String assunto) {
    this.assunto = assunto;
  }

  /**
   * @return the instituicao
   */
  public String getInstituicao() {
    return instituicao;
  }

  /**
   * @param instituicao
   *            the instituicao to set
   */
  public void setInstituicao(String instituicao) {
    this.instituicao = instituicao;
  }

  /**
   * @return the autor
   */
  public String getAutor() {
    return autor;
  }

  /**
   * @param autor
   *            the autor to set
   */
  public void setAutor(String autor) {
    this.autor = autor;
  }

  /**
   * @return the fileName
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * @param fileName
   *            the fileName to set
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   * @return the postagemNumber
   */
  public String getPostagemNumber() {
    return postagemNumber;
  }

  /**
   * @param postagemNumber
   *            the postagemNumber to set
   */
  public void setPostagemNumber(String postagemNumber) {
    this.postagemNumber = postagemNumber;
  }

}
