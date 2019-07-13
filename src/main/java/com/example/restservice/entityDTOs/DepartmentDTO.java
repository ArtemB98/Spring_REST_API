package com.example.restservice.entityDTOs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Department")
public class DepartmentDTO {
    @XmlElement
    private Long departmentId;
    @XmlElement
    private String departmentName;
    @XmlElement
    private Long managerId;
    @XmlElement
    private Long locationId;

    public Long getDepartmentId() {
        return departmentId;
    }

    @XmlTransient
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getManagerId() {
        return managerId;
    }

    @XmlTransient
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getLocationId() {
        return locationId;
    }

    @XmlTransient
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @XmlTransient
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
