package br.com.jm.musiclib.model.converter;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import br.com.jm.musiclib.model.Comment;
import br.com.jm.musiclib.model.Resposta;
import br.com.jm.musiclib.model.Music;

/**
 * Implementação do Converter para objetos do tipo Music.
 */
@ApplicationScoped
public class MusicConverter implements Converter<Music> {

  /** Conversor para objetos Comment. */
  private Converter<Comment> commentConv;
  
  /** Conversor para objetos Resposta. */
  private Converter<Resposta> respostaConv;

  /**
   * Construtor.
   * @param commentConverter Conversor de objetos Comment. Injetado pelo CDI.
   */
  @Inject
  public MusicConverter(Converter<Comment> commentConverter, Converter<Resposta> respConverter) {
    this.commentConv = commentConverter;
    this.respostaConv = respConverter;
  }

  /** Construtor sem parâmetros - necessário para o CDI. */
  public MusicConverter() {}

  /** {@inheritDoc} */
  @Override
  public DBObject toDBObject(Music music) {
    DBObject doc = new BasicDBObject();

    doc.put("postagemNumber", music.getPostagemNumber());
    doc.put("assunto", music.getAssunto());
    doc.put("autor", music.getAutor());
    doc.put("instituicao", music.getInstituicao());

    if (music.getFileId() != null) {
      doc.put("fileId", new ObjectId(music.getFileId()));
    }

    BasicDBList tagsList = new BasicDBList();
    for (String tag : music.getTags()) {
      tagsList.add(tag);
    }
    doc.put("tags", tagsList);

    BasicDBList comentariosList = new BasicDBList();
    for (Comment comentario : music.getComments()) {
      comentariosList.add(commentConv.toDBObject(comentario));
    }
    doc.put("comments", comentariosList);
    
    BasicDBList respostasList = new BasicDBList();
    for (Resposta comentario : music.getRespostas()) {
      respostasList.add(respostaConv.toDBObject(comentario));
    }
    doc.put("respostas", respostasList);

    return doc;
  }

  /** {@inheritDoc} */
  @SuppressWarnings("unchecked")
  @Override
  public Music toObject(DBObject doc) {

    List<DBObject> commentDocs = (List<DBObject>) doc.get("comments");
    SortedSet<Comment> comments = new TreeSet<Comment>();
    
    List<DBObject> respDocs = (List<DBObject>) doc.get("respostas");
    SortedSet<Resposta> respostas = new TreeSet<Resposta>();
    
    String fileId;

    for (DBObject commentDoc : commentDocs) {
      comments.add(commentConv.toObject(commentDoc));
    }
    
    for (DBObject respDoc : respDocs) {
      respostas.add(respostaConv.toObject(respDoc));
    }

    if (doc.get("fileId") != null) {
      fileId = ((ObjectId) doc.get("fileId")).toString();
    }
    else {
      fileId = "";
    }

    Music music = new Music(((ObjectId) doc.get("_id")).toString(),
        (Integer) doc.get("postagemNumber"), (String) doc.get("assunto"),
        (String) doc.get("autor"), (String) doc.get("instituicao"), fileId,
        (List<String>) doc.get("tags"), comments, respostas);

    return music;
  }

}
