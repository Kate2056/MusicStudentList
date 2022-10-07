/**
 * @author Kaitlyn Briggs - krbriggs
 * CIS175 - Fall 2022
 * Oct 6, 2022
 */
package model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListDetails{
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private MusicTeacher musicTeacher;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListMusicStudent> listOfStudents;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	public MusicTeacher getMusicTeacher() {
		return musicTeacher;
	}
	public void setMusicTeacher(MusicTeacher musicTeacher) {
		this.musicTeacher = musicTeacher;
	}
	public List<ListMusicStudent> getListOfStudents() {
		return listOfStudents;
	}
	public void setListOfStudents(List<ListMusicStudent> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, MusicTeacher musicTeacher, List<ListMusicStudent> listOfStudents) {
		super();
		this.id = id;
		this.listName = listName;
		this.musicTeacher = musicTeacher;
		this.listOfStudents = listOfStudents;
	}
	public ListDetails(String listName, MusicTeacher musicTeacher, List<ListMusicStudent> listOfStudents) {
		super();
		this.listName = listName;
		this.musicTeacher = musicTeacher;
		this.listOfStudents = listOfStudents;
	}
	public ListDetails(String listName, MusicTeacher musicTeacher) {
		super();
		this.listName = listName;
		this.musicTeacher = musicTeacher;
	}
	
}