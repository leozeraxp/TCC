package springboot.tcc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Cartao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Usuario usuario;
	
	private String titulo;
	
	private String descricao;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Link> links = new ArrayList<Link>() ;
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public void addLink(Link link) {
        this.links.add(link);
    }
	
	public void addCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}



	public List<Link> getLinks() {
		return links;
	}


	public void setLinks(List<Link> links) {
		this.links = links;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
