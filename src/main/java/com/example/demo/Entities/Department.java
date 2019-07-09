package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@XmlRootElement(name = "Department")
@Entity
@Table(name = "DEPARTMENTS")
public class Department {
    @XmlElement
    private Long departmentId;
    @XmlElement
    private String departmentName;

    @XmlElement
    private Long managerId;
    @XmlElement
    private Long locationId;


    private Employee employeeByManagerId;
    private Location locationByLocationId;
    private Collection<Employee> employeeByDepartmentId;
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

        Department that = (Department) o;

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
    public Employee getEmployeeByManagerId() {
        return employeeByManagerId;
    }

    @XmlTransient
    @JsonIgnore
    public void setEmployeeByManagerId(Employee employeeByManagerId) {
        this.employeeByManagerId = employeeByManagerId;
    }

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID", insertable = false, updatable = false)
    public Location getLocationByLocationId() {
        return locationByLocationId;
    }

    @XmlTransient
    @JsonIgnore
    public void setLocationByLocationId(Location locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<Employee> getEmployeeByDepartmentId() {
        return employeeByDepartmentId;
    }

    @XmlTransient
    @JsonIgnore
    public void setEmployeeByDepartmentId(Collection<Employee> employeeByDepartmentId) {
        this.employeeByDepartmentId = employeeByDepartmentId;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<JobHistory> getJobHistoriesByDepartmentId() {
        return jobHistoriesByDepartmentId;
    }

    @XmlTransient
    @JsonIgnore
    public void setJobHistoriesByDepartmentId(Collection<JobHistory> jobHistoriesByDepartmentId) {
        this.jobHistoriesByDepartmentId = jobHistoriesByDepartmentId;
    }
}
