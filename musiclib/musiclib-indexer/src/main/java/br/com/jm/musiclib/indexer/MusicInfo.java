package br.com.jm.musiclib.indexer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto que contém as informações extraidas dos arquivos mp3
 * 
 * 
 */
public class MusicInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** ID único da questão na coleção */
	private Long id;
	
	/** Assunto da questão */
	private String assunto;
	
	/** Nome do autor */
	private String autor;
	
	/** Nome da instituição */
	private String instituicao;
	
	/** Número da questão */
	private String postagemNumber;
	
	/** lista de tags associadas à questão */
	private List<String> tags;
	
	/** Nome do arquivo com as informações extraídas */
	private String fileName;

	/**
	 * Construtor padrão.
	 */
	public MusicInfo() {
		this.tags = new ArrayList<String>();
	}

	/**
	 * Adiciona uma tag
	 * 
	 * @param tag
	 *            Tag a ser adicionada
	 * @return true se a tag foi inserida
	 */
	public boolean addTag(String tag) {
		return this.tags.add(tag);
	}

	/**
	 * Remove uma tag
	 * 
	 * @param tag
	 *            Tag a ser removida
	 * @return true se a tag foi removida
	 */
	public boolean removeTag(String tag) {
		return this.tags.remove(tag);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the assunto
	 */
	public String getAssunto() {
		return assunto;
	}

	/**
	 * @param assunto
	 *            the assunto to set
	 */
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor
	 *            the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the instituicao
	 */
	public String getInstituicao() {
		return instituicao;
	}

	/**
	 * @param instituicao
	 *            the instituicao to set
	 */
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	/**
	 * @return the postagemNumber
	 */
	public String getPostagemNumber() {
		return postagemNumber;
	}

	/**
	 * @param postagemNumber
	 *            the postagemNumber to set
	 */
	public void setPostagemNumber(String postagemNumber) {
		this.postagemNumber = postagemNumber;
	}

	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
