package br.com.jm.musiclib.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

import br.com.jm.musiclib.indexer.MusicIndexer;
import br.com.jm.musiclib.indexer.MusicIndexerEvent;
import br.com.jm.musiclib.indexer.MusicInfo;
import br.com.jm.musiclib.indexer.impl.MusicIndexerImplementacao;

/**
 * Bean que guarda a última música encontrada pelo indexador de músicas.
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
   * Referência para a última questão encontrada
   */
  private MusicInfo currentMusicInfo;

  /**
   * Flag que indica se o processo de indexação está completo.
   */
  private boolean completed;

  /**
   * Recebe um evento do tipo MusicIndexerEvent disparado pelo MusicIndexer.
   * Salva a referência da questão encontrada e marca se o precesso foi
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
   * @return a questão atual. Null se não existe.
   */
  public MusicInfo getCurrentMusicInfo() {
    return currentMusicInfo;
  }

  /**
   * Altera a questão atual
   * 
   * @param currentMusicInfo
   */
  public void setCurrentMusicInfo(MusicInfo currentMusicInfo) {
    this.currentMusicInfo = currentMusicInfo;
  }

  /**
   * @return o assunto da questão atual ou vazio se não existe
   */
  public String getAssunto() {
    return currentMusicInfo == null ? "" : currentMusicInfo.getAssunto();
  }

  /**
   * @return o autor da questão atual ou vazio se não existe
   */
  public String getAutor() {
    return currentMusicInfo == null ? "" : currentMusicInfo.getAutor();
  }

  /**
   * @return o a instituição do autor da questão atual ou vazio se não existe
   */
  public String getInstituicao() {
    return currentMusicInfo == null ? "" : currentMusicInfo.getInstituicao();
  }

  /**
   * @return o nome do arquivo da questão atual ou vazio se não existe
   */
  public String getFileName() {
    return currentMusicInfo == null ? "" : currentMusicInfo.getFileName();
  }

  /**
   * @return a faixa da questão atual ou vazio se não existe
   */
  public String getPostagemNumber() {
    return currentMusicInfo == null ? "" : currentMusicInfo.getPostagemNumber();
  }

  /**
   * @return flag indicando que o processo de indexação foi finalizado.
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
