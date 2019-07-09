package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@XmlRootElement(name = "Job")
@Entity
@Table(name = "JOBS")
public class Job {
    @XmlElement
    private String jobId;
    @XmlElement
    private String jobTitle;
    @XmlElement
    private Long minSalary;
    @XmlElement
    private Long maxSalary;
    private Collection<Employee> employeeByJobId;
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

        Job job = (Job) o;

        if (jobId != null ? !jobId.equals(job.jobId) : job.jobId != null) return false;
        if (jobTitle != null ? !jobTitle.equals(job.jobTitle) : job.jobTitle != null) return false;
        if (minSalary != null ? !minSalary.equals(job.minSalary) : job.minSalary != null) return false;
        if (maxSalary != null ? !maxSalary.equals(job.maxSalary) : job.maxSalary != null) return false;

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

    @OneToMany(mappedBy = "jobByJobId")
    public Collection<Employee> getEmployeeByJobId() {
        return employeeByJobId;
    }

    @XmlTransient
    @JsonIgnore
    public void setEmployeeByJobId(Collection<Employee> employeeByJobId) {
        this.employeeByJobId = employeeByJobId;
    }

    @OneToMany(mappedBy = "jobByJobId")
    public Collection<JobHistory> getJobHistoriesByJobId() {
        return jobHistoriesByJobId;
    }

    @XmlTransient
    @JsonIgnore
    public void setJobHistoriesByJobId(Collection<JobHistory> jobHistoriesByJobId) {
        this.jobHistoriesByJobId = jobHistoriesByJobId;
    }
}
