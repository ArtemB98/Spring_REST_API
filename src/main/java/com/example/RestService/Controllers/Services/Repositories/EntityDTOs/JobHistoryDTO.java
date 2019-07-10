package com.example.RestService.Controllers.Services.Repositories.EntityDTOs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Date;

@XmlRootElement(name = "JobHistory")
public class JobHistoryDTO {
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

    public Long getEmployeeId() {
        return employeeId;
    }

    @XmlTransient
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    @XmlTransient
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @XmlTransient
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobId() {
        return jobId;
    }

    @XmlTransient
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
