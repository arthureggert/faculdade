/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author tkbernardi
 */
@Entity(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue
	private int codigo;
	@Column
	private String descricao;
	@Column
	private String cor;

	public Categoria() {

	}

	public Categoria(int codigo, String descricao, String cor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.cor = cor;
	}

	/**
	 * @return the cogigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param cogigo
	 *            the cogigo to set
	 */
	public void setCodigo(int cogigo) {
		this.codigo = cogigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the cor
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * @param cor
	 *            the cor to set
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

}
