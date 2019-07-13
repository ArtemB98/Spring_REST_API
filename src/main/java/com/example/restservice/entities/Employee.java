package com.example.restservice.entities;


import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private Long salary;
    private Long commissionPct;
    private String job_id;
    private Long manager_id;
    private Long department_id;

    @Basic
    @Column(name = "MANAGER_ID", nullable = true, length = 6)
    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    @Basic
    @Column(name = "DEPARTMENT_ID", nullable = true, length = 6)
    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    @Basic
    @Column(name = "JOB_ID", nullable = false, length = 10)
    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    private Collection<Department> departmentByEmployeeId;
    private Job jobByJobId;
    private Employee employeeByManagerId;
    private Collection<Employee> employeeByEmployeeId;
    private Department departmentByDepartmentId;
    private Collection<JobHistory> jobHistoriesByEmployeeId;

    public Employee() {
        super();
    }

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 25)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 25)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE_NUMBER", nullable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "HIRE_DATE", nullable = false)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

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

    public void setCommissionPct(Long commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeId != null ? !employeeId.equals(employee.employeeId) : employee.employeeId != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null)
            return false;
        if (hireDate != null ? !hireDate.equals(employee.hireDate) : employee.hireDate != null) return false;
        if (salary != null ? !salary.equals(employee.salary) : employee.salary != null) return false;
        if (commissionPct != null ? !commissionPct.equals(employee.commissionPct) : employee.commissionPct != null)
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

    @OneToMany(mappedBy = "employeeByManagerId")
    public Collection<Department> getDepartmentByEmployeeId() {
        return departmentByEmployeeId;
    }

    public void setDepartmentByEmployeeId(Collection<Department> departmentByEmployeeId) {
        this.departmentByEmployeeId = departmentByEmployeeId;
    }

    @ManyToOne ////////////////////
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", nullable = false, insertable = false, updatable = false)
    public Job getJobByJobId() {
        return jobByJobId;
    }

    public void setJobByJobId(Job jobByJobId) {
        this.jobByJobId = jobByJobId;
    }

    @ManyToOne /////////////////////
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID", insertable = false, updatable = false)
    public Employee getEmployeeByManagerId() {
        return employeeByManagerId;
    }

    public void setEmployeeByManagerId(Employee employeeByManagerId) {
        this.employeeByManagerId = employeeByManagerId;
    }

    @OneToMany(mappedBy = "employeeByManagerId")
    public Collection<Employee> getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Collection<Employee> employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @ManyToOne /////////////
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID", insertable = false, updatable = false)
    public Department getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<JobHistory> getJobHistoriesByEmployeeId() {
        return jobHistoriesByEmployeeId;
    }

    public void setJobHistoriesByEmployeeId(Collection<JobHistory> jobHistoriesByEmployeeId) {
        this.jobHistoriesByEmployeeId = jobHistoriesByEmployeeId;
    }
}
