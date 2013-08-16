package br.com.jm.musiclib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma playlist de um usu�rio.
 */
public class Playlist implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -8169017665776508348L;

  /** Nome da playlist. */
  private String name;

  /** Lista de identificadores de quest�es pertencentes � playlist. */
  private List<String> musics;

  /**
   * Construtor.
   * @param name Nome da playlist.
   */
  public Playlist(String name) {
    this(name, new ArrayList<String>());
  }

  /**
   * Construtor.
   * @param name Nome da playlist.
   * @param musics Lista de identificadores das quest�es que pertencem
   * � playlist.
   */
  public Playlist(String name, List<String> musics) {
    this.name = name;
    this.musics = musics;
  }

  /**
   * Obt�m a lista de identificadres das quest�es da playlist.
   * @return lista de identificadres das quest�es da playlist.
   */
  public List<String> getMusics() {
    return this.musics;
  }

  /**
   * Obt�m nome da playlist.
   * @return Nome da playlist.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Adiciona uma nova quest�o � playlist.
   * @param music Quest�o a ser adicionada.
   */
  public void addMusic(Music music) {
    this.musics.add(music.getId());
  }

}
