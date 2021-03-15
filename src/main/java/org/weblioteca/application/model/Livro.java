package org.weblioteca.application.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRO")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long livroId;
	private String tituloLivro;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Autor autor;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Editora editora;
	
	private int quantidade;
	private String localizacao;
	private boolean disponivelEmprestimo;

	public Livro() {
	}

	public Long getLivroId() {
		return livroId;
	}

	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public boolean isDisponivelEmprestimo() {
		return disponivelEmprestimo;
	}

	public void setDisponivelEmprestimo(boolean disponivelEmprestimo) {
		this.disponivelEmprestimo = disponivelEmprestimo;
	}

}
