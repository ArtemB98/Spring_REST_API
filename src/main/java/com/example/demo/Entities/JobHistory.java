package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Date;

@Entity
@Table(name = "JOB_HISTORY", schema = "HR", catalog = "")
@IdClass(JobHistoryPK.class)
@XmlRootElement(name = "JobHistory")
public class JobHistory {
    @XmlElement
    private Long employeeId;
    @XmlElement
    private Date startDate;
    @XmlElement
    private Date endDate;


    @XmlElement
    private String jobId;
    @XmlElement
    private Long departmentId;


    private Employees employeesByEmployeeId;
    private Jobs jobsByJobId;
    private Departments departmentsByDepartmentId;


    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public Long getEmployeeId() {
        return employeeId;
    }

    @XmlTransient
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Id
    @Column(name = "START_DATE", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    @XmlTransient
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "JOB_ID", nullable = false, precision = 0)
    public String getJobId() {
        return jobId;
    }

    @XmlTransient
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "DEPARTMENT_ID", nullable = true, precision = 0)
    public Long getDepartmentId() {
        return departmentId;
    }

    @XmlTransient
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }


    @Basic
    @Column(name = "END_DATE", nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    @XmlTransient
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobHistory that = (JobHistory) o;

        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @ManyToOne //////////////////////////////
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", nullable = false, insertable = false, updatable = false)
    public Employees getEmployeesByEmployeeId() {
        return employeesByEmployeeId;
    }

    @XmlTransient
    @JsonIgnore
    public void setEmployeesByEmployeeId(Employees employeesByEmployeeId) {
        this.employeesByEmployeeId = employeesByEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", nullable = false, insertable = false, updatable = false)
    public Jobs getJobsByJobId() {
        return jobsByJobId;
    }

    @XmlTransient
    @JsonIgnore
    public void setJobsByJobId(Jobs jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID", insertable = false, updatable = false)
    public Departments getDepartmentsByDepartmentId() {
        return departmentsByDepartmentId;
    }

    @XmlTransient
    @JsonIgnore
    public void setDepartmentsByDepartmentId(Departments departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }
}
