package com.suong.entity;
// Generated Jun 28, 2017 11:53:33 PM by Hibernate Tools 5.1.0.Alpha1

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
 * Cbyt generated by hbm2java
 */
@Entity
@Proxy(lazy = false)
@Table(name = "cbyt", catalog = "preschool")
public class Cbyt implements java.io.Serializable {

	private Integer id;
	private String macbyt;
	private String hoTencbyt;
	private String trinhDo;
	private String chuyenMon;
	private String diaChi;
	private String phone;
	private Boolean status;
	private Set<Khamsuckhoe> khamsuckhoes = new HashSet<Khamsuckhoe>(0);

	public Cbyt() {
	}

	public Cbyt(String macbyt, String hoTencbyt, String trinhDo, String chuyenMon, String diaChi, String phone) {
		this.macbyt = macbyt;
		this.hoTencbyt = hoTencbyt;
		this.trinhDo = trinhDo;
		this.chuyenMon = chuyenMon;
		this.diaChi = diaChi;
		this.phone = phone;
	}

	public Cbyt(String macbyt, String hoTencbyt, String trinhDo, String chuyenMon, String diaChi, String phone,
			Boolean status, Set<Khamsuckhoe> khamsuckhoes) {
		this.macbyt = macbyt;
		this.hoTencbyt = hoTencbyt;
		this.trinhDo = trinhDo;
		this.chuyenMon = chuyenMon;
		this.diaChi = diaChi;
		this.phone = phone;
		this.status = status;
		this.khamsuckhoes = khamsuckhoes;
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

	@Column(name = "macbyt", nullable = false, length = 30)
	public String getMacbyt() {
		return this.macbyt;
	}

	public void setMacbyt(String macbyt) {
		this.macbyt = macbyt;
	}

	@Column(name = "ho_tencbyt", nullable = false, length = 40)
	public String getHoTencbyt() {
		return this.hoTencbyt;
	}

	public void setHoTencbyt(String hoTencbyt) {
		this.hoTencbyt = hoTencbyt;
	}

	@Column(name = "trinh_do", nullable = false, length = 30)
	public String getTrinhDo() {
		return this.trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	@Column(name = "chuyen_mon", nullable = false, length = 30)
	public String getChuyenMon() {
		return this.chuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	@Column(name = "dia_chi", nullable = false, length = 50)
	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Column(name = "phone", nullable = false, length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbyt")
	public Set<Khamsuckhoe> getKhamsuckhoes() {
		return this.khamsuckhoes;
	}

	public void setKhamsuckhoes(Set<Khamsuckhoe> khamsuckhoes) {
		this.khamsuckhoes = khamsuckhoes;
	}

}
