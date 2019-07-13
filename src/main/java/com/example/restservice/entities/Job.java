package com.example.restservice.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "JOBS")
public class Job {
    private String jobId;
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;
    private Collection<Employee> employeeByJobId;
    private Collection<JobHistory> jobHistoriesByJobId;

    @Id
    @Column(name = "JOB_ID", nullable = false, length = 10)
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "JOB_TITLE", nullable = false, length = 35)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "MIN_SALARY", nullable = true, precision = 0)
    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    @Basic
    @Column(name = "MAX_SALARY", nullable = true, precision = 0)
    public Long getMaxSalary() {
        return maxSalary;
    }

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

    public void setEmployeeByJobId(Collection<Employee> employeeByJobId) {
        this.employeeByJobId = employeeByJobId;
    }

    @OneToMany(mappedBy = "jobByJobId")
    public Collection<JobHistory> getJobHistoriesByJobId() {
        return jobHistoriesByJobId;
    }

    public void setJobHistoriesByJobId(Collection<JobHistory> jobHistoriesByJobId) {
        this.jobHistoriesByJobId = jobHistoriesByJobId;
    }
}
