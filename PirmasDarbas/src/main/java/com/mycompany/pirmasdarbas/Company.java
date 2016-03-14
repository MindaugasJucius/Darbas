/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pirmasdarbas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mindaugas
 */
@Entity
@Table(name = "COMPANY")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id"),
    @NamedQuery(name = "Company.findByTitle", query = "SELECT c FROM Company c WHERE c.title = :title"),
    @NamedQuery(name = "Company.findByOptLockVersion", query = "SELECT c FROM Company c WHERE c.optLockVersion = :optLockVersion")})
public class Company implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TAX_PAYERS_ID")
    private String taxPayersId;

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    
    @OneToMany(mappedBy = "companyId")
    private List<Employee> employeeList;

    public Company() {
    }

    public Company(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += taxPayersId.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        return this.taxPayersId.equals(other.taxPayersId);
    }

    @Override
    public String toString() {
        return "com.mycompany.pirmasdarbas.Company[ id=" + id + " ]";
    }

    public String getTaxPayersId() {
        return taxPayersId;
    }

    public void setTaxPayersId(String taxPayersId) {
        this.taxPayersId = taxPayersId;
    }
    
}
