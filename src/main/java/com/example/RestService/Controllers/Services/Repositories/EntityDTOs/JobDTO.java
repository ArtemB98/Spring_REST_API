package com.example.RestService.Controllers.Services.Repositories.EntityDTOs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Job")
public class JobDTO {
    @XmlElement
    private String jobId;
    @XmlElement
    private String jobTitle;
    @XmlElement
    private Long minSalary;
    @XmlElement
    private Long maxSalary;

    public String getJobId() {
        return jobId;
    }

    @XmlTransient
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @XmlTransient
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getMinSalary() {
        return minSalary;
    }

    @XmlTransient
    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public Long getMaxSalary() {
        return maxSalary;
    }

    @XmlTransient
    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }
}
