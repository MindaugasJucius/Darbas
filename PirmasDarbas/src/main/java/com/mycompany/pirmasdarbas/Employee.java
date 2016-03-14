/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pirmasdarbas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mindaugas
 */
@Entity
@Table(name = "EMPLOYEE")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employee.findByStartDate", query = "SELECT e FROM Employee e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "Employee.findByOptLockVersion", query = "SELECT e FROM Employee e WHERE e.optLockVersion = :optLockVersion")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Size(max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SSN")
    private String ssn;
    
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    
    @JoinTable(name = "EMPLOYEE_TEAM", joinColumns = {
        @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "TEAM_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Team> teamList;
    
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Company companyId;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        return this.ssn.equals(other.ssn);
    }

    @Override
    public String toString() {
        return "com.mycompany.pirmasdarbas.Employee[ id=" + id + " ]";
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
}
