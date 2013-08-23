package br.com.jm.musiclib.model.converter;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import br.com.jm.musiclib.model.Resposta;

/**
 * Implementação do Converter para objetos do tipo Resposta.
 */
@ApplicationScoped
public class RespostaConverter implements Converter<Resposta> {

  /** {@inheritDoc} */
  @Override
  public DBObject toDBObject(Resposta comment) {
    DBObject doc = new BasicDBObject();
    doc.put("postDate", comment.getPostDate());
    doc.put("message", comment.getMessage());
    doc.put("userName", comment.getUserName());

    return doc;
  }

  /** {@inheritDoc} */
  @Override
  public Resposta toObject(DBObject doc) {
    Resposta comment = new Resposta((Date) doc.get("postDate"),
        (String) doc.get("message"),
        (String) doc.get("userName"));

    return comment;
  }

}
