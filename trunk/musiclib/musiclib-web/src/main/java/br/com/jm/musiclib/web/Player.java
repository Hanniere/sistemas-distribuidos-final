package br.com.jm.musiclib.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jm.musiclib.model.Comment;
import br.com.jm.musiclib.model.Resposta;
import br.com.jm.musiclib.model.Music;
import br.com.jm.musiclib.model.MusicService;
import br.com.jm.musiclib.model.Playlist;
import br.com.jm.musiclib.model.UserService;

/**
 * Bean respons�vel por gerenciar o Player.
 * 
 * 
 */
@Named
@SessionScoped
public class Player implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -2550035241033339662L;

  /**
   * EJB MusicService injetado pelo container.
   */
  @Inject
  private MusicService musicService;

  @Inject
  private UserService userService;

  /**
   * UserBean injetado pelo container.
   */
  @Inject
  private UserBean user;

  /**
   * Posi��o atual da quest�o que est� sendo tocada.
   */
  private int currentIndex = 0;

  /**
   * Nome da playlist selecionada
   */
  private String selectedPlaylist;
  /**
   * Playlist selecionada.
   */
  private Playlist currentPlaylist;
  /**
   * Lista de quest�es da playlist selecionada
   */
  private List<Music> musics;
  /**
   * �udio que est� tocando.
   */
  private Music currentMusic;
  /**
   * Novo coment�rio que pode ser adicionado pelo usu�rio
   */
  private Comment comment = new Comment();
  
  /**
   * Nova resposta que pode ser adicionado pelo usu�rio
   */
  private Resposta resposta = new Resposta();

  /**
   * @return o nome da playlist selecionada
   */
  public String getSelectedPlaylist() {
    return this.selectedPlaylist;
  }

  /**
   * Altera o nome da playlist selecionada.
   * 
   * @param playlist
   */
  public void setSelectedPlaylist(String playlist) {
    this.selectedPlaylist = playlist;

  }

  /**
   * @return a playlist selecionada
   */
  public Playlist getCurrentPlaylist() {
    return this.currentPlaylist;
  }

  /**
   * 
   * @return a quest�o atual.
   */
  public Music getCurrentMusic() {
    return currentMusic;
  }

  /**
   * 
   * @return a lista de quest�es da playlist selecionada ou lista vazia caso
   *         n�o exista nenhuma playlist selecionada.
   * 
   */
  public List<Music> getMusics() {
    if (selectedPlaylist == null) { return Collections.emptyList(); }
    return musics;
  }

  /**
   * Seleciona a playlist e zera a posi��o do �ndice.
   */
  public void selectPlaylist() {
    currentIndex = 0;

    if (selectedPlaylist != null) {
      for (Playlist p : user.getCurrentUser().getPlaylists()) {
        if (p.getName().equals(this.selectedPlaylist)) {
          this.currentPlaylist = p;
          break;
        }
      }

      musics = new ArrayList<Music>();
      for (String musicId : currentPlaylist.getAudios()) {
        musics.add(musicService.getMusic(musicId));
      }
      updateCurrentMusic();
    }
  }

  /**
   * Move o �ndice para a posi��o anterior.
   */
  public void previous() {
    currentIndex--;
    if (currentIndex < 0) {
      currentIndex = getMusics().size() - 1;
    }
    updateCurrentMusic();
  }

  /**
   * Move o �ndice para a pr�xima posi��o.
   */
  public void next() {
    currentIndex++;
    if (currentIndex >= getMusics().size()) {
      currentIndex = 0;
    }
    updateCurrentMusic();
  }

  private void updateCurrentMusic() {
    // Obt�m a m�sica correspondente ao objeto atual
    currentMusic = musics.get(currentIndex);

    // incrementa o numer de execu��es
    userService.play(user.getCurrentUser(), currentMusic);
  }

  /**
   * Salva um coment�rio feito pelo usu�rio
   * 
   * @see MusicService#addComment(Music, Comment)
   */
  public void saveComment() {
    comment.setUserName(user.getCurrentUser().getName());
    comment.setPostDate(new Date());
    currentMusic.addComment(comment);

    musicService.addComment(currentMusic, comment);
    comment = new Comment();
  }
  
  /**
   * Salva uma resposta dada pelo usu�rio
   * 
   * @see MusicService#addComment(Music, Comment)
   */
  public void saveResposta() {
    comment.setUserName(user.getCurrentUser().getName());
    comment.setPostDate(new Date());
    currentMusic.addResposta(resposta);

    musicService.addResposta(currentMusic, resposta);
    comment = new Comment();
  }

  /**
   * 
   * @return o objeto comment
   */
  public Comment getComment() {
    return comment;
  }

  /**
   * Altera o objeto comment
   * 
   * @param comment
   */
  public void setComment(Comment comment) {
    this.comment = comment;
  }
  
  /**
   * 
   * @return o objeto resposta
   */
  public Resposta getResposta() {
    return resposta;
  }

  /**
   * Altera o objeto resposta
   * 
   * @param comment
   */
  public void setResposta(Resposta comment) {
    this.resposta = comment;
  }

}
