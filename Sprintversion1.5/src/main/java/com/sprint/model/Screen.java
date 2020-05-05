package com.sprint.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="screen")
public class Screen implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int screenId;
	private String screenName;
	@OneToMany(targetEntity = Show.class, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="screenshow_fk", referencedColumnName = "screenId")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Show> shows = new ArrayList<>();


	public Screen() {

	}

	public Screen(int theaterId, String screenName, List<Show> shows) {
		super();
		this.screenName = screenName;
		this.shows = shows;
	}

	// Getters and Setters
	public int getScreeId() {
		return screenId;
	}

	public void setScreeId(int screeId) {
		this.screenId = screeId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenName=" + screenName + ", shows=" + shows + "]";
	}

	



}
