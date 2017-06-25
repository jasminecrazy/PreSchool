package com.suong.entity;
// Generated Jun 25, 2017 10:47:14 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

/**
 * Thutienhoc generated by hbm2java
 */
@Entity
@Proxy(lazy=false)
@Table(name = "thutienhoc", catalog = "preschool")
public class Thutienhoc implements java.io.Serializable {

	private Integer id;
	private Hocsinh hocsinh;
	private String mabienlai;
	private Date ngaythu;
	private int tienhocphi;
	private float tienan;
	private float tienphuthu;
	private float tongtien;
	private String namhoc;
	private Integer tiendadong;
	private Integer tienchuadong;

	public Thutienhoc() {
	}

	public Thutienhoc(Hocsinh hocsinh, String mabienlai, Date ngaythu, int tienhocphi, float tienan, float tienphuthu,
			float tongtien, String namhoc) {
		this.hocsinh = hocsinh;
		this.mabienlai = mabienlai;
		this.ngaythu = ngaythu;
		this.tienhocphi = tienhocphi;
		this.tienan = tienan;
		this.tienphuthu = tienphuthu;
		this.tongtien = tongtien;
		this.namhoc = namhoc;
	}

	public Thutienhoc(Hocsinh hocsinh, String mabienlai, Date ngaythu, int tienhocphi, float tienan, float tienphuthu,
			float tongtien, String namhoc, Integer tiendadong, Integer tienchuadong) {
		this.hocsinh = hocsinh;
		this.mabienlai = mabienlai;
		this.ngaythu = ngaythu;
		this.tienhocphi = tienhocphi;
		this.tienan = tienan;
		this.tienphuthu = tienphuthu;
		this.tongtien = tongtien;
		this.namhoc = namhoc;
		this.tiendadong = tiendadong;
		this.tienchuadong = tienchuadong;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mahs", nullable = false)
	public Hocsinh getHocsinh() {
		return this.hocsinh;
	}

	public void setHocsinh(Hocsinh hocsinh) {
		this.hocsinh = hocsinh;
	}

	@Column(name = "mabienlai", nullable = false, length = 50)
	public String getMabienlai() {
		return this.mabienlai;
	}

	public void setMabienlai(String mabienlai) {
		this.mabienlai = mabienlai;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngaythu", nullable = false, length = 10)
	public Date getNgaythu() {
		return this.ngaythu;
	}

	public void setNgaythu(Date ngaythu) {
		this.ngaythu = ngaythu;
	}

	@Column(name = "tienhocphi", nullable = false)
	public int getTienhocphi() {
		return this.tienhocphi;
	}

	public void setTienhocphi(int tienhocphi) {
		this.tienhocphi = tienhocphi;
	}

	@Column(name = "tienan", nullable = false, precision = 12, scale = 0)
	public float getTienan() {
		return this.tienan;
	}

	public void setTienan(float tienan) {
		this.tienan = tienan;
	}

	@Column(name = "tienphuthu", nullable = false, precision = 12, scale = 0)
	public float getTienphuthu() {
		return this.tienphuthu;
	}

	public void setTienphuthu(float tienphuthu) {
		this.tienphuthu = tienphuthu;
	}

	@Column(name = "tongtien", nullable = false, precision = 12, scale = 0)
	public float getTongtien() {
		return this.tongtien;
	}

	public void setTongtien(float tongtien) {
		this.tongtien = tongtien;
	}

	@Column(name = "namhoc", nullable = false, length = 50)
	public String getNamhoc() {
		return this.namhoc;
	}

	public void setNamhoc(String namhoc) {
		this.namhoc = namhoc;
	}

	@Column(name = "tiendadong")
	public Integer getTiendadong() {
		return this.tiendadong;
	}

	public void setTiendadong(Integer tiendadong) {
		this.tiendadong = tiendadong;
	}

	@Column(name = "tienchuadong")
	public Integer getTienchuadong() {
		return this.tienchuadong;
	}

	public void setTienchuadong(Integer tienchuadong) {
		this.tienchuadong = tienchuadong;
	}

}
