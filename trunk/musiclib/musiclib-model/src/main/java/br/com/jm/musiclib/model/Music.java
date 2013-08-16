package br.com.jm.musiclib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Classe que representa uma quest�o em �udio da aplica��o.
 */
public class Music implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -3471296001691844288L;

  /** Identificador interno da quest�o. */
  private String id;

  /** N�mero da quest�o. */
  private int trackNumber;

  /** Nome da quest�o. */
  private String title;

  /** Autor da quest�o. */
  private String artistName;

  /** Nome da institui��o. */
  private String albumName;

  /** Indentificador para o arquivo. */
  private String fileId;

  /** Lista de tags associadas � m�sica. */
  private List<String> tags;

  /** Conjunto de coment�rios associados � quest�o. */
  private SortedSet<Comment> comments;
  
  /** Conjunto de respostas associadas � quest�o. */
  private SortedSet<Resposta> respostas;

  /**
   * Construtor.
   * @param trackNumber N�mero da quest�o.
   * @param title Nome da quest�o.
   * @param artistName Nome do autor.
   * @param albumName Nome da institui��o.
   * @param fileId Identificador para o arquivo.
   * @param tag Uma tag para a quest�o.
   */
  public Music(int trackNumber, String title, String artistName,
      String albumName, String fileId, String tag)
  {
    this(null, trackNumber, title, artistName, albumName, fileId, Collections
        .singletonList(tag), new TreeSet<Comment>(), new TreeSet<Resposta>());
  }

  /**
   * Construtor com todos os atributos.
   * 
   * @param id Identificador interno da quest�o.
   * @param trackNumber N�mero da quest�o.
   * @param title Nome da quest�o.
   * @param artistName Nome do autor.
   * @param albumName Nome da institui��o.
   * @param fileId Identificador para o arquivo.
   * @param tags Lista de tags associadas � quest�o.
   * @param comments Conjunto de coment�rios associados � quest�o.
   * @param respostas Conjunto de respostas associados � quest�o.
   */
  public Music(String id, int trackNumber, String title, String artistName,
      String albumName, String fileId, List<String> tags,
      SortedSet<Comment> comments, SortedSet<Resposta> respostas)
  {
    this.id = id;
    this.trackNumber = trackNumber;
    this.title = title;
    this.artistName = artistName;
    this.albumName = albumName;
    this.fileId = fileId;
    this.tags = new ArrayList<String>(tags);
    this.comments = comments;
    this.respostas = respostas;
  }

  /**
   * Obt�m identificador interno da quest�o.
   * @return identificador interno da quest�o.
   */
  public String getId() {
    return this.id;
  }

  /**
   * Obt�m n�mero da quest�o.
   * @return n�mero da quest�o.
   */
  public int getTrackNumber() {
    return trackNumber;
  }

  /**
   * Obt�m t�tulo da quest�o.
   * @return T�tulo da quest�o.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Obt�m nome da quest�o.
   * @return Nome da quest�o.
   */
  public String getArtistName() {
    return this.artistName;
  }

  /**
   * Obt�m nome da institui��o.
   * @return Nome da institui��o.
   */
  public String getAlbumName() {
    return this.albumName;
  }

  /**
   * Obt�m lista de tags associadas � quest�o.
   * @return lista de tags associadas � quest�o.
   */
  public List<String> getTags() {
    return this.tags;
  }

  /**
   * Obt�m conjunto de coment�rios associados � quest�o.
   * @return conjunto de coment�rios associados � quest�o.
   */
  public SortedSet<Comment> getComments() {
    return this.comments;
  }

  /**
   * @return o conjunto de coment�rios como uma lista.
   * 
   * @see #getComments()
   */
  public List<Comment> getCommentsAsList() {
    return new ArrayList<Comment>(getComments());
  }

  /**
   * Obt�m identificador para o arquivo.
   * @return Identificador para o arquivo.
   */
  public String getFileId() {
    return this.fileId;
  }

  /**
   * Configura o identificador interno da quest�o.
   * @param id identificador interno da quest�o.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Adiciona uma nova tag ao conjunto de tags da quest�o.
   * @param tag Nova tag a ser adicionada.
   */
  public void addTag(String tag) {
    this.tags.add(tag);
  }
  
  /**
   * Obt�m conjunto de respostas associados � quest�o.
   * @return conjunto de respostas associados � quest�o.
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
   * Adiciona novo coment�rio ao conjunto de coment�rios associados.
   * @param comment Coment�rio a ser adicionado.
   */
  public void addComment(Comment comment) {
    this.comments.add(comment);
  }
  
  /**
   * Adiciona novo coment�rio ao conjunto de respostas associadas.
   * @param comment Coment�rio a ser adicionado.
   */
  public void addResposta(Resposta comment) {
    this.respostas.add(comment);
  }

}
