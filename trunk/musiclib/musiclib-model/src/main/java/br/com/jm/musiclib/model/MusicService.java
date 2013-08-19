package br.com.jm.musiclib.model;

import java.util.List;

import br.com.jm.musiclib.indexer.MusicIndexerEvent;

/**
 * Interface de serviço contendo os métodos para manipulação de questões.
 */
public interface MusicService {

  /**
   * Obtém uma questão a partir de seu identificador interno.
   * @param musicId Identificador interno da questão.
   * @return Questão a partir do identificador informado.
   */
  public Music getMusic(String musicId);

  /**
   * Busca por questões que possuem em seu nome a String informada como filtro.
   * @param search String a ser utilizada como filtro.
   * @return Todas questões que possuem em seu nome o filtro informado.
   */
  public List<Music> searchMusics(String search);

  /**
   * Adiciona uma nova tag a questão informada.
   * @param music Questão sendo alterada.
   * @param tag Tag a ser adicionada.
   */
  public void addTag(Music music, String tag);

  /**
   * Adiciona um novo comentário a questão informada.
   * @param music Questão sendo alterada.
   * @param comment Comentário a ser adicionado.
   */
  public void addComment(Music music, Comment comment);
  
  /**
   * Adiciona um novo comentário a questão informada.
   * @param music Questão sendo alterada.
   * @param comment Comentário a ser adicionado.
   */
  public void addResposta(Music music, Resposta comment);

  /**
   * Obtém objeto que representa o arquivo com os dados binários da questão.
   * @param musicFileId Identificador do arquivo a ser obtido.
   * @return objeto que representa o arquivo com os dados binários da questão.
   */
  public MusicFile getMusicFile(String musicFileId);

  /**
   * Processa um evento gerado pelo componente indexer.
   * @param event Evento a ser processado.
   * @return Questão criada resultante do processamento do evento.
   */
  public Music processIndexerEvent(MusicIndexerEvent event);

}