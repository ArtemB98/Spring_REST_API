package com.example.RestService.Controllers.Services.Repositories.EntityDTOs;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Date;

@XmlRootElement(name = "Employee")
public class EmployeeDTO {
    @XmlElement
    private Long employeeId;
    @XmlElement
    private String firstName;
    @XmlElement
    private String lastName;
    @XmlElement
    private String email;
    @XmlElement
    private String phoneNumber;
    @XmlElement
    private Date hireDate;
    @XmlElement
    private Long salary;
    @XmlElement
    private Long commissionPct;
    @XmlElement
    private String job_id;
    @XmlElement
    private Long manager_id;
    @XmlElement
    private Long department_id;

    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public Long getEmployeeId() {
        return employeeId;
    }

    @XmlTransient
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlTransient
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlTransient
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    @XmlTransient
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @XmlTransient
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    @XmlTransient
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Long getSalary() {
        return salary;
    }

    @XmlTransient
    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getCommissionPct() {
        return commissionPct;
    }

    @XmlTransient
    public void setCommissionPct(Long commissionPct) {
        this.commissionPct = commissionPct;
    }

    public String getJob_id() {
        return job_id;
    }

    @XmlTransient
    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public Long getManager_id() {
        return manager_id;
    }

    @XmlTransient
    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    @XmlTransient
    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }
}
