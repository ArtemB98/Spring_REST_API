package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@XmlRootElement(name = "Department")
@Entity
public class Departments {
    @XmlElement
    private Long departmentId;
    @XmlElement
    private String departmentName;

    @XmlElement
    private Long managerId;
    @XmlElement
    private Long locationId;


    private Employees employeesByManagerId;
    private Locations locationsByLocationId;
    private Collection<Employees> employeesByDepartmentId;
    private Collection<JobHistory> jobHistoriesByDepartmentId;

    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false, precision = 0)
    public Long getDepartmentId() {
        return departmentId;
    }

    @XmlTransient
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "MANAGER_ID", nullable = true, precision = 0)
    public Long getManagerId() {
        return managerId;
    }

    @XmlTransient
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "LOCATION_ID", nullable = true, precision = 0)
    public Long getLocationId() {
        return locationId;
    }

    @XmlTransient
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }


    @Basic
    @Column(name = "DEPARTMENT_NAME", nullable = false, length = 30)
    public String getDepartmentName() {
        return departmentName;
    }

    @XmlTransient
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departments that = (Departments) o;

        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId != null ? departmentId.hashCode() : 0;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        return result;
    }


    @ManyToOne
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID", insertable = false, updatable = false)
    public Employees getEmployeesByManagerId() {
        return employeesByManagerId;
    }

    @XmlTransient
    @JsonIgnore
    public void setEmployeesByManagerId(Employees employeesByManagerId) {
        this.employeesByManagerId = employeesByManagerId;
    }

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID", insertable = false, updatable = false)
    public Locations getLocationsByLocationId() {
        return locationsByLocationId;
    }

    @XmlTransient
    @JsonIgnore
    public void setLocationsByLocationId(Locations locationsByLocationId) {
        this.locationsByLocationId = locationsByLocationId;
    }

    @OneToMany(mappedBy = "departmentsByDepartmentId")
    public Collection<Employees> getEmployeesByDepartmentId() {
        return employeesByDepartmentId;
    }

    @XmlTransient
    @JsonIgnore
    public void setEmployeesByDepartmentId(Collection<Employees> employeesByDepartmentId) {
        this.employeesByDepartmentId = employeesByDepartmentId;
    }

    @OneToMany(mappedBy = "departmentsByDepartmentId")
    public Collection<JobHistory> getJobHistoriesByDepartmentId() {
        return jobHistoriesByDepartmentId;
    }

    @XmlTransient
    @JsonIgnore
    public void setJobHistoriesByDepartmentId(Collection<JobHistory> jobHistoriesByDepartmentId) {
        this.jobHistoriesByDepartmentId = jobHistoriesByDepartmentId;
    }
}
