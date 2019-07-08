package com.example.demo.Entities;

import com.example.demo.Entities.Employees;
import com.example.demo.Entities.JobHistory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@XmlRootElement(name="Jobs")
@Entity
public class Jobs {
    @XmlElement
    private String jobId;
    @XmlElement
    private String jobTitle;
    @XmlElement
    private Long minSalary;
    @XmlElement
    private Long maxSalary;
    private Collection<Employees> employeesByJobId;
    private Collection<JobHistory> jobHistoriesByJobId;

    @Id
    @Column(name = "JOB_ID", nullable = false, length = 10)
    public String getJobId() {
        return jobId;
    }
    @XmlTransient
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "JOB_TITLE", nullable = false, length = 35)
    public String getJobTitle() {
        return jobTitle;
    }
    @XmlTransient
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "MIN_SALARY", nullable = true, precision = 0)
    public Long getMinSalary() {
        return minSalary;
    }
    @XmlTransient
    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    @Basic
    @Column(name = "MAX_SALARY", nullable = true, precision = 0)
    public Long getMaxSalary() {
        return maxSalary;
    }
    @XmlTransient
    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jobs jobs = (Jobs) o;

        if (jobId != null ? !jobId.equals(jobs.jobId) : jobs.jobId != null) return false;
        if (jobTitle != null ? !jobTitle.equals(jobs.jobTitle) : jobs.jobTitle != null) return false;
        if (minSalary != null ? !minSalary.equals(jobs.minSalary) : jobs.minSalary != null) return false;
        if (maxSalary != null ? !maxSalary.equals(jobs.maxSalary) : jobs.maxSalary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobId != null ? jobId.hashCode() : 0;
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (minSalary != null ? minSalary.hashCode() : 0);
        result = 31 * result + (maxSalary != null ? maxSalary.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "jobsByJobId")
    public Collection<Employees> getEmployeesByJobId() {
        return employeesByJobId;
    }
    @XmlTransient
    @JsonIgnore
    public void setEmployeesByJobId(Collection<Employees> employeesByJobId) {
        this.employeesByJobId = employeesByJobId;
    }

    @OneToMany(mappedBy = "jobsByJobId")
    public Collection<JobHistory> getJobHistoriesByJobId() {
        return jobHistoriesByJobId;
    }
    @XmlTransient
    @JsonIgnore
    public void setJobHistoriesByJobId(Collection<JobHistory> jobHistoriesByJobId) {
        this.jobHistoriesByJobId = jobHistoriesByJobId;
    }
}
