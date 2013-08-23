package br.com.jm.musiclib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma playlist de um usuário.
 */
public class Playlist implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -8169017665776508348L;

  /** Nome da playlist. */
  private String name;

  /** Lista de identificadores de questões pertencentes à playlist. */
  private List<String> audios;

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
   * @param audios Lista de identificadores das questões que pertencem
   * à playlist.
   */
  public Playlist(String name, List<String> audios) {
    this.name = name;
    this.audios = audios;
  }

  /**
   * Obtém a lista de identificadres das questões da playlist.
   * @return lista de identificadres das questões da playlist.
   */
  public List<String> getAudios() {
    return this.audios;
  }

  /**
   * Obtém nome da playlist.
   * @return Nome da playlist.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Adiciona uma nova questão à playlist.
   * @param music Questão a ser adicionada.
   */
  public void addMusic(Music music) {
    this.audios.add(music.getId());
  }

}
