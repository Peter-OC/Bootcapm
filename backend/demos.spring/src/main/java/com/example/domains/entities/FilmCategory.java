package com.example.domains.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.example.domains.core.entities.EntityBase;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Objects;


/**
 * The persistent class for the film_category database table.
 * 
 */
@Entity
@Table(name="film_category")
@NamedQuery(name="FilmCategory.findAll", query="SELECT f FROM FilmCategory f")
public class FilmCategory extends EntityBase<FilmCategory> implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FilmCategoryPK id;

	@Column(name="last_update")
	@Generated(value = GenerationTime.ALWAYS)
	@PastOrPresent
	@JsonFormat(pattern = "yyy-MM-dd hh:mm:ss")
	private Timestamp lastUpdate;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id", insertable=false, updatable=false)
	private Category category;

	//bi-directional many-to-one association to Film
	@ManyToOne
	@JoinColumn(name="film_id", insertable=false, updatable=false)
	private Film film;

	public FilmCategory() {
	}
	
	public FilmCategory(FilmCategoryPK id) {
		super();
		this.id = id;
	}

	public FilmCategory(FilmCategoryPK id, @PastOrPresent Timestamp lastUpdate, Category category, Film film) {
		super();
		this.id = id;
		this.lastUpdate = lastUpdate;
		this.category = category;
		this.film = film;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof FilmCategory))
			return false;
		FilmCategory other = (FilmCategory) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "FilmCategory [id=" + id + ", category=" + category + ", film=" + film + "]";
	}

	public FilmCategoryPK getId() {
		return this.id;
	}

	public void setId(FilmCategoryPK id) {
		this.id = id;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}