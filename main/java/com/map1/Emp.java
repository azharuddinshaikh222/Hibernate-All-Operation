package com.map1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.List;
@Entity
public class Emp {
@Id	
private int eid;
private String name;
@ManyToMany

private List<Project> projects;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Project> getProjects() {
	return projects;
}
public void setProjects(List<Project> projects) {
	this.projects = projects;
}
public Emp(int eid, String name, List<Project> projects) {
	super();
	this.eid = eid;
	this.name = name;
	this.projects = projects;
}
public Emp() {
	super();
	// TODO Auto-generated constructor stub
}

}
