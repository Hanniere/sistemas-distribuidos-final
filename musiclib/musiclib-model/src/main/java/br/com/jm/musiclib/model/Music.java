package br.com.jm.musiclib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Classe que representa uma questão em áudio da aplicação.
 */
public class Music implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -3471296001691844288L;

  /** Identificador interno da questão. */
  private String id;

  /** Número da postagem. */
  private int postagemNumber;

  /** Assunto da questão. */
  private String assunto;

  /** Autor da questão. */
  private String autor;

  /** Nome da instituição. */
  private String instituicao;

  /** Indentificador para o arquivo. */
  private String fileId;

  /** Lista de tags associadas à música. */
  private List<String> tags;

  /** Conjunto de comentários associados à questão. */
  private SortedSet<Comment> comments;
  
  /** Conjunto de respostas associadas à questão. */
  private SortedSet<Resposta> respostas;

  /**
   * Construtor.
   * @param postagemNumber Número da questão.
   * @param assunto Nome da questão.
   * @param autor Nome do autor.
   * @param instituicao Nome da instituição.
   * @param fileId Identificador para o arquivo.
   * @param tag Uma tag para a questão.
   */
  public Music(int postagemNumber, String assunto, String autor,
      String instituicao, String fileId, String tag)
  {
    this(null, postagemNumber, assunto, autor, instituicao, fileId, Collections
        .singletonList(tag), new TreeSet<Comment>(), new TreeSet<Resposta>());
  }

  /**
   * Construtor com todos os atributos.
   * 
   * @param id Identificador interno da questão.
   * @param postagemNumber Número da questão.
   * @param assunto Nome da questão.
   * @param autor Nome do autor.
   * @param instituicao Nome da instituição.
   * @param fileId Identificador para o arquivo.
   * @param tags Lista de tags associadas à questão.
   * @param comments Conjunto de comentários associados à questão.
   * @param respostas Conjunto de respostas associados à questão.
   */
  public Music(String id, int trackNumber, String title, String artistName,
      String albumName, String fileId, List<String> tags,
      SortedSet<Comment> comments, SortedSet<Resposta> respostas)
  {
    this.id = id;
    this.postagemNumber = trackNumber;
    this.assunto = title;
    this.autor = artistName;
    this.instituicao = albumName;
    this.fileId = fileId;
    this.tags = new ArrayList<String>(tags);
    this.comments = comments;
    this.respostas = respostas;
  }

  /**
   * Obtém identificador interno da questão.
   * @return identificador interno da questão.
   */
  public String getId() {
    return this.id;
  }

  /**
   * Obtém número da questão.
   * @return número da questão.
   */
  public int getPostagemNumber() {
    return postagemNumber;
  }

  /**
   * Obtém título da questão.
   * @return Título da questão.
   */
  public String getAssunto() {
    return this.assunto;
  }

  /**
   * Obtém nome da questão.
   * @return Nome da questão.
   */
  public String getAutor() {
    return this.autor;
  }

  /**
   * Obtém nome da instituição.
   * @return Nome da instituição.
   */
  public String getInstituicao() {
    return this.instituicao;
  }

  /**
   * Obtém lista de tags associadas à questão.
   * @return lista de tags associadas à questão.
   */
  public List<String> getTags() {
    return this.tags;
  }

  /**
   * Obtém conjunto de comentários associados à questão.
   * @return conjunto de comentários associados à questão.
   */
  public SortedSet<Comment> getComments() {
    return this.comments;
  }

  /**
   * @return o conjunto de comentários como uma lista.
   * 
   * @see #getComments()
   */
  public List<Comment> getCommentsAsList() {
    return new ArrayList<Comment>(getComments());
  }

  /**
   * Obtém identificador para o arquivo.
   * @return Identificador para o arquivo.
   */
  public String getFileId() {
    return this.fileId;
  }

  /**
   * Configura o identificador interno da questão.
   * @param id identificador interno da questão.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Adiciona uma nova tag ao conjunto de tags da questão.
   * @param tag Nova tag a ser adicionada.
   */
  public void addTag(String tag) {
    this.tags.add(tag);
  }
  
  /**
   * Obtém conjunto de respostas associados à questão.
   * @return conjunto de respostas associados à questão.
   */
  public SortedSet<Resposta> getRespostas() {
    return this.respostas;
  }

  /**
   * @return o conjunto de respostas como uma lista.
   * 
   * @see #getComments()
   */
  public List<Resposta> getRespostasAsList() {
    return new ArrayList<Resposta>(getRespostas());
  }


  /**
   * Adiciona novo comentário ao conjunto de comentários associados.
   * @param comment Comentário a ser adicionado.
   */
  public void addComment(Comment comment) {
    this.comments.add(comment);
  }
  
  /**
   * Adiciona novo comentário ao conjunto de respostas associadas.
   * @param comment Comentário a ser adicionado.
   */
  public void addResposta(Resposta comment) {
    this.respostas.add(comment);
  }

}
