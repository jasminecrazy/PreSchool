package com.suong.entity;
// Generated Jun 18, 2017 4:58:24 PM by Hibernate Tools 5.1.0.Alpha1

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

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "preschool")
public class Employee implements java.io.Serializable {

	private Integer id;
	private String employeeId;
	private String employeeName;
	private String chucVu;
	private String trinhdo;
	private String chuyenmon;
	private String address;
	private String phone;
	private Set<Nkdkh> nkdkhs = new HashSet<Nkdkh>(0);
	private Set<Thutienhoc> thutienhocs = new HashSet<Thutienhoc>(0);

	public Employee() {
	}

	public Employee(String employeeId, String employeeName, String chucVu, String trinhdo, String chuyenmon,
			String address, String phone) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.chucVu = chucVu;
		this.trinhdo = trinhdo;
		this.chuyenmon = chuyenmon;
		this.address = address;
		this.phone = phone;
	}

	public Employee(String employeeId, String employeeName, String chucVu, String trinhdo, String chuyenmon,
			String address, String phone, Set<Nkdkh> nkdkhs, Set<Thutienhoc> thutienhocs) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.chucVu = chucVu;
		this.trinhdo = trinhdo;
		this.chuyenmon = chuyenmon;
		this.address = address;
		this.phone = phone;
		this.nkdkhs = nkdkhs;
		this.thutienhocs = thutienhocs;
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

	@Column(name = "employee_id", nullable = false, length = 50)
	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "employee_name", nullable = false, length = 50)
	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Column(name = "chuc_vu", nullable = false, length = 20)
	public String getChucVu() {
		return this.chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	@Column(name = "trinhdo", nullable = false, length = 50)
	public String getTrinhdo() {
		return this.trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	@Column(name = "chuyenmon", nullable = false, length = 30)
	public String getChuyenmon() {
		return this.chuyenmon;
	}

	public void setChuyenmon(String chuyenmon) {
		this.chuyenmon = chuyenmon;
	}

	@Column(name = "Address", nullable = false, length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone", nullable = false, length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Nkdkh> getNkdkhs() {
		return this.nkdkhs;
	}

	public void setNkdkhs(Set<Nkdkh> nkdkhs) {
		this.nkdkhs = nkdkhs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Thutienhoc> getThutienhocs() {
		return this.thutienhocs;
	}

	public void setThutienhocs(Set<Thutienhoc> thutienhocs) {
		this.thutienhocs = thutienhocs;
	}

}
