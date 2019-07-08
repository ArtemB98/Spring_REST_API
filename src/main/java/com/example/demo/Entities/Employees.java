package com.example.demo.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Date;
import java.util.Collection;

@XmlRootElement(name="Employee")
@Entity
public class Employees {
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
    @Basic
    @Column(name = "MANAGER_ID", nullable = true, length = 6)
    public Long getManager_id() {
        return manager_id;
    }
    @XmlTransient
    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }
    @Basic
    @Column(name = "DEPARTMENT_ID", nullable = true, length = 6)
    public Long getDepartment_id() {
        return department_id;
    }
    @XmlTransient
    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }
    @Basic
    @Column(name = "JOB_ID", nullable = false, length = 10)
    public String getJob_id() {
        return job_id;
    }
    @XmlTransient
    public void setJob_id(String job_id) { this.job_id = job_id; }


    private Collection<Departments> departmentsByEmployeeId;
    private Jobs jobsByJobId;
    private Employees employeesByManagerId;
    private Collection<Employees> employeesByEmployeeId;
    private Departments departmentsByDepartmentId;
    private Collection<JobHistory> jobHistoriesByEmployeeId;

    public Employees(){super();}
    //public Employees(Long employeeId,String firstName, String lastName, String email, String phoneNumber, Time hireDate, Long Salary, Long commissionPct)
    //{

  //  }
    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public Long getEmployeeId() {
        return employeeId;
    }
    @XmlTransient
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 20)
    public String getFirstName() {
        return firstName;
    }
    @XmlTransient
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 25)
    public String getLastName() {
        return lastName;
    }
    @XmlTransient
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 25)
    public String getEmail() {
        return email;
    }
    @XmlTransient
    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE_NUMBER", nullable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @XmlTransient
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "HIRE_DATE", nullable = false)
    //public Time getHireDate() {
    public Date getHireDate() {
        return hireDate;
    }

    @XmlTransient
   // public void setHireDate(Time hireDate) {
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @XmlTransient
    @Basic
    @Column(name = "SALARY", nullable = true, precision = 2)
    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "COMMISSION_PCT", nullable = true, precision = 2)
    public Long getCommissionPct() {
        return commissionPct;
    }

    @XmlTransient
    public void setCommissionPct(Long commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (employeeId != null ? !employeeId.equals(employees.employeeId) : employees.employeeId != null) return false;
        if (firstName != null ? !firstName.equals(employees.firstName) : employees.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employees.lastName) : employees.lastName != null) return false;
        if (email != null ? !email.equals(employees.email) : employees.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employees.phoneNumber) : employees.phoneNumber != null)
            return false;
        if (hireDate != null ? !hireDate.equals(employees.hireDate) : employees.hireDate != null) return false;
        if (salary != null ? !salary.equals(employees.salary) : employees.salary != null) return false;
        if (commissionPct != null ? !commissionPct.equals(employees.commissionPct) : employees.commissionPct != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (commissionPct != null ? commissionPct.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeesByManagerId")
    public Collection<Departments> getDepartmentsByEmployeeId() {
        return departmentsByEmployeeId;
    }

    @XmlTransient
    @JsonIgnore
    public void setDepartmentsByEmployeeId(Collection<Departments> departmentsByEmployeeId) {
        this.departmentsByEmployeeId = departmentsByEmployeeId;
    }

    @ManyToOne ////////////////////
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", nullable = false,insertable=false, updatable=false)
    public Jobs getJobsByJobId() {
        return jobsByJobId;
    }

    @XmlTransient
    @JsonIgnore
    public void setJobsByJobId(Jobs jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }

    @ManyToOne /////////////////////
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID",insertable=false, updatable=false)
    public Employees getEmployeesByManagerId() {
        return employeesByManagerId;
    }

    @XmlTransient
    @JsonIgnore
    public void setEmployeesByManagerId(Employees employeesByManagerId) {
        this.employeesByManagerId = employeesByManagerId;
    }

    @OneToMany(mappedBy = "employeesByManagerId")
    public Collection<Employees> getEmployeesByEmployeeId() {
        return employeesByEmployeeId;
    }

    @XmlTransient
    @JsonIgnore
    public void setEmployeesByEmployeeId(Collection<Employees> employeesByEmployeeId) {
        this.employeesByEmployeeId = employeesByEmployeeId;
    }

    @ManyToOne /////////////
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID",insertable=false, updatable=false)
    public Departments getDepartmentsByDepartmentId() {
        return departmentsByDepartmentId;
    }

    @XmlTransient
    @JsonIgnore
    public void setDepartmentsByDepartmentId(Departments departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }

    @OneToMany(mappedBy = "employeesByEmployeeId")
    public Collection<JobHistory> getJobHistoriesByEmployeeId() {
        return jobHistoriesByEmployeeId;
    }

    @XmlTransient
    @JsonIgnore
    public void setJobHistoriesByEmployeeId(Collection<JobHistory> jobHistoriesByEmployeeId) {
        this.jobHistoriesByEmployeeId = jobHistoriesByEmployeeId;
    }
}
