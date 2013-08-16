package br.com.jm.musiclib.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

import br.com.jm.musiclib.indexer.MusicIndexer;
import br.com.jm.musiclib.indexer.MusicIndexerEvent;
import br.com.jm.musiclib.indexer.MusicInfo;
import br.com.jm.musiclib.indexer.impl.MusicIndexerImpl;

/**
 * Bean que guarda a �ltima m�sica encontrada pelo indexador de m�sicas.
 * 
 * 
 */
@SessionScoped
public class StatusBean implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 6445790885225082845L;
  /**
   * Refer�ncia para a �ltima quest�o encontrada
   */
  private MusicInfo currentMusicInfo;

  /**
   * Flag que indica se o processo de indexa��o est� completo.
   */
  private boolean completed;

  /**
   * Recebe um evento do tipo MusicIndexerEvent disparado pelo MusicIndexer.
   * Salva a refer�ncia da quest�o encontrada e marca se o precesso foi
   * finalizado.
   * 
   * @param event
   * 
   * @see MusicIndexer
   * @see MusicIndexerImpl
   */
  public void process(@Observes MusicIndexerEvent event) {
    setCurrentMusicInfo(event.getMusicInfo());
    setCompleted(event.getCompleted());
  }

  /**
   * @return a quest�o atual. Null se n�o existe.
   */
  public MusicInfo getCurrentMusicInfo() {
    return currentMusicInfo;
  }

  /**
   * Altera a quest�o atual
   * 
   * @param currentMusicInfo
   */
  public void setCurrentMusicInfo(MusicInfo currentMusicInfo) {
    this.currentMusicInfo = currentMusicInfo;
  }

  /**
   * @return o t�tulo da quest�o atual ou vazio se n�o existe
   */
  public String getTitle() {
    return currentMusicInfo == null ? "" : currentMusicInfo.getTitle();
  }

  /**
   * @return o autor da quest�o atual ou vazio se n�o existe
   */
  public String getArtist() {
    return currentMusicInfo == null ? "" : currentMusicInfo.getArtist();
  }

  /**
   * @return o a institui��o do autor da quest�o atual ou vazio se n�o existe
   */
  public String getAlbum() {
    return currentMusicInfo == null ? "" : currentMusicInfo.getAlbum();
  }

  /**
   * @return o nome do arquivo da quest�o atual ou vazio se n�o existe
   */
  public String getFileName() {
    return currentMusicInfo == null ? "" : currentMusicInfo.getFileName();
  }

  /**
   * @return a faixa da quest�o atual ou vazio se n�o existe
   */
  public String getTrackNumber() {
    return currentMusicInfo == null ? "" : currentMusicInfo.getTrackNumber();
  }

  /**
   * @return flag indicando que o processo de indexa��o foi finalizado.
   */
  public boolean getCompleted() {
    return completed;
  }

  /**
   * Altera a flag q indica que o processo foi finalizado
   * 
   * @param completed
   */
  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

}
