package br.com.jm.musiclib.model.cdi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Qualificador CDI - qualifica objetos DBCollection como cole��es de quest�es.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD,
    ElementType.PARAMETER })
public @interface MusicCollection {

}
