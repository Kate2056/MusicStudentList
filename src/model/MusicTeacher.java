package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// package and import statements
@Entity
public class MusicTeacher { 
@Id
@GeneratedValue
private int id;
private String musicTeacherName;

public MusicTeacher() {
	super ();
//TODO Auto-generated constructor stub
}

public MusicTeacher( int id, String musicTeacherName) {
	super ();
	this.id = id;
	this.musicTeacherName = musicTeacherName;
}

public MusicTeacher(String musicTeacherName) {
	super();
	this.musicTeacherName = musicTeacherName;

}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getMusicTeacher() {
	return musicTeacherName;
}

public void setMusicTeacherName(String musicTeacher) {
	this.musicTeacherName = musicTeacher;
}

@Override
public String toString() {
	return "Music Teacher [id=" + id + ", musicTeacherName=" + musicTeacherName + "]";
}
}