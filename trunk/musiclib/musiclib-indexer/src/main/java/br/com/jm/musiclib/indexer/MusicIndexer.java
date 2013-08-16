package br.com.jm.musiclib.indexer;

import java.io.File;

/**
 * Interface que define os m�todos que um indexador de quest�es deve implementar.
 *
 */
public interface MusicIndexer {

	/**
	 * Procura por arquivos com extens�o mp3 nas pastas especificadas pelo
	 * parametro <tt>root</tt>
	 * 
	 * @param root
	 *            o caminho completo da pasta para procurar pelos arquivos
	 * @see MusicIndexerImpl#createIndex(File)
	 */
	public abstract void createIndex(String root);

	/**
	 * Procura por arquivos com extens�o mp3 nas pastas especificadas pelo
	 * parametro <tt>root</tt>
	 * 
	 * @param root
	 *            um objeto File com o caminho completo da pasta para procurar
	 *            pelos arquivos
	 * @see MusicIndexerImpl#createIndex(String)
	 */
	public abstract void createIndex(File root);

}