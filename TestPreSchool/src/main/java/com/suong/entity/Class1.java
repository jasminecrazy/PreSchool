package com.suong.entity;
// Generated Jun 19, 2017 8:57:33 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Class1 generated by hbm2java
 */
@Entity
@Proxy(lazy=false)
@Table(name = "class1", catalog = "preschool")
public class Class1 implements java.io.Serializable {

	private Integer id;
	private String classId;
	private String className;
	private int quantity;
	private Set<Nktheodoi> nktheodois = new HashSet<Nktheodoi>(0);
	private Set<Phanlop> phanlops = new HashSet<Phanlop>(0);

	public Class1() {
	}

	public Class1(String classId, String className, int quantity) {
		this.classId = classId;
		this.className = className;
		this.quantity = quantity;
	}

	public Class1(String classId, String className, int quantity, Set<Nktheodoi> nktheodois, Set<Phanlop> phanlops) {
		this.classId = classId;
		this.className = className;
		this.quantity = quantity;
		this.nktheodois = nktheodois;
		this.phanlops = phanlops;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "class_id", nullable = false, length = 50)
	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Column(name = "class_name", nullable = false, length = 50)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "class1")
	public Set<Nktheodoi> getNktheodois() {
		return this.nktheodois;
	}

	public void setNktheodois(Set<Nktheodoi> nktheodois) {
		this.nktheodois = nktheodois;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "class1")
	public Set<Phanlop> getPhanlops() {
		return this.phanlops;
	}

	public void setPhanlops(Set<Phanlop> phanlops) {
		this.phanlops = phanlops;
	}

}
