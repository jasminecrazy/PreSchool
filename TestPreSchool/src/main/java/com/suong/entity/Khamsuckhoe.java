package com.suong.entity;
// Generated Jun 24, 2017 10:08:12 AM by Hibernate Tools 5.1.0.Alpha1

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
 * Khamsuckhoe generated by hbm2java
 */
@Entity
@Proxy(lazy=false)
@Table(name = "khamsuckhoe", catalog = "preschool")
public class Khamsuckhoe implements java.io.Serializable {

	private Integer id;
	private Cbyt cbyt;
	private Hocsinh hocsinh;
	private String sophieukham;
	private int lankham;
	private Date namhoc;
	private Date ngaykham;
	private String chieucao;
	private String cannang;
	private String benh;
	private String ketluan;

	public Khamsuckhoe() {
	}

	public Khamsuckhoe(Cbyt cbyt, Hocsinh hocsinh, String sophieukham, int lankham, Date namhoc, Date ngaykham,
			String chieucao, String cannang, String ketluan) {
		this.cbyt = cbyt;
		this.hocsinh = hocsinh;
		this.sophieukham = sophieukham;
		this.lankham = lankham;
		this.namhoc = namhoc;
		this.ngaykham = ngaykham;
		this.chieucao = chieucao;
		this.cannang = cannang;
		this.ketluan = ketluan;
	}

	public Khamsuckhoe(Cbyt cbyt, Hocsinh hocsinh, String sophieukham, int lankham, Date namhoc, Date ngaykham,
			String chieucao, String cannang, String benh, String ketluan) {
		this.cbyt = cbyt;
		this.hocsinh = hocsinh;
		this.sophieukham = sophieukham;
		this.lankham = lankham;
		this.namhoc = namhoc;
		this.ngaykham = ngaykham;
		this.chieucao = chieucao;
		this.cannang = cannang;
		this.benh = benh;
		this.ketluan = ketluan;
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
	@JoinColumn(name = "macbyt", nullable = false)
	public Cbyt getCbyt() {
		return this.cbyt;
	}

	public void setCbyt(Cbyt cbyt) {
		this.cbyt = cbyt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mahocsinh", nullable = false)
	public Hocsinh getHocsinh() {
		return this.hocsinh;
	}

	public void setHocsinh(Hocsinh hocsinh) {
		this.hocsinh = hocsinh;
	}

	@Column(name = "sophieukham", nullable = false, length = 10)
	public String getSophieukham() {
		return this.sophieukham;
	}

	public void setSophieukham(String sophieukham) {
		this.sophieukham = sophieukham;
	}

	@Column(name = "lankham", nullable = false)
	public int getLankham() {
		return this.lankham;
	}

	public void setLankham(int lankham) {
		this.lankham = lankham;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "namhoc", nullable = false, length = 0)
	public Date getNamhoc() {
		return this.namhoc;
	}

	public void setNamhoc(Date namhoc) {
		this.namhoc = namhoc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngaykham", nullable = false, length = 10)
	public Date getNgaykham() {
		return this.ngaykham;
	}

	public void setNgaykham(Date ngaykham) {
		this.ngaykham = ngaykham;
	}

	@Column(name = "chieucao", nullable = false, length = 10)
	public String getChieucao() {
		return this.chieucao;
	}

	public void setChieucao(String chieucao) {
		this.chieucao = chieucao;
	}

	@Column(name = "cannang", nullable = false, length = 10)
	public String getCannang() {
		return this.cannang;
	}

	public void setCannang(String cannang) {
		this.cannang = cannang;
	}

	@Column(name = "benh", length = 100)
	public String getBenh() {
		return this.benh;
	}

	public void setBenh(String benh) {
		this.benh = benh;
	}

	@Column(name = "ketluan", nullable = false)
	public String getKetluan() {
		return this.ketluan;
	}

	public void setKetluan(String ketluan) {
		this.ketluan = ketluan;
	}

}
