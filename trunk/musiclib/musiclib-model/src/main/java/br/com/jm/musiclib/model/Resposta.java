package br.com.jm.musiclib.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe que representa uma resposta das quest�es.
 * 
 */
public class Resposta implements Comparable<Resposta>, Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -5879534563674225503L;

  /** Data de postagem. */
  private Date postDate;

  /** Nota dada para a quest�o. */
  //private double grade;

  /** Mensagem associada a resposta. */
  private String message;

  /** Nome do usu�rio associada a resposta. */
  private String userName;

  /**
   * Construtor.
   * 
   * @param date
   *            Data de postagem.
   * @param message
   *            Mensagem associada a resposta.
   * @param userName
   *            Nome do usu�rio associado a resposta.
   */
  public Resposta(Date date, String message, String userName) {
    this.postDate = date;
    //this.grade = grade;
    this.message = message;
    this.userName = userName;
  }

  /**
   * Construtor vazio.
   */
  public Resposta() {

  }

  /**
   * Obt�m data de postagem.
   * 
   * @return Data de postagem da resposta.
   */
  public Date getPostDate() {
    return postDate;
  }


  /**
   * Obt�m mensagem associada a resposta.
   * 
   * @return Mensagem associada a resposta.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Obt�m usu�rio associado a resposta.
   * 
   * @return Usu�rio associado a resposta.
   */
  public String getUserName() {
    return userName;
  }

  /** {@inheritDoc} */
  @Override
  public int compareTo(Resposta obj) {
    return this.postDate.compareTo(obj.postDate);
  }

  /**
   * @param postDate
   *            the postDate to set
   */
  public void setPostDate(Date postDate) {
    this.postDate = postDate;
  }

  /**
   * @param message
   *            the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @param userName
   *            the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

}
