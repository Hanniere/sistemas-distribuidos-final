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
 * Bean responsável por monitorar o andamento da indexação e atualizar o status
 * para o usuário. Verifica o bean StatusBean para obter as informações.
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
  /** Assunto da questão indexada */
  private String assunto;
  /** Instituição da questão indexada */
  private String instituicao;
  /** Autor da questão indexada */
  private String autor;
  /** Nome do arquivo da questão indexada */
  private String fileName;
  /** Número da questão indexada */
  private String postagemNumber;

  /**
   * Atualiza o status dos campos de acordo com o estado do bean StatusBean.
   * Esse método deve ser invocado pela página que irá exibir o estado da
   * indexação.
   * 
   * Quando a indexação é finalizada, o fluxo é redirecionado para a página
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
