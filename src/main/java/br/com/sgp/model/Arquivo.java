package br.com.sgp.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;
/**
 * Classe para armazenar informações sobre o arquivo
 * 
 * @author weslley.magalhaes
 *
 */


@Entity
public class Arquivo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -780466039136708385L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Content type
	 */
	
	
	private String type;

	private String name;
	
	private String originalName;
	
	private String path = UUID.randomUUID().toString();

	
	public Arquivo() {

	}
	
	public Arquivo(MultipartFile file) {
		this.type = file.getContentType();
		this.name = file.getName();
		this.originalName = file.getOriginalFilename();	
		this.path = path.concat(originalName.subSequence(originalName.lastIndexOf("."),originalName.length()).toString());
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
