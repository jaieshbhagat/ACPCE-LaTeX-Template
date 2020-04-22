package org.acpce.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Staff extends CustomUser {

    private static final long serialVersionUID = 1L;

    private String srn;
    @ManyToOne
    private Department department;
    private StaffType type;
    private LocalDateTime joiningDate;
    private LocalDateTime leavingDate;
    private AssociationType associationType;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Qualification> qualification;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER, mappedBy = "customUser")
    private Set<Designation> designation;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "authors")
    private Set<Conference> conferences;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Course> coursesTaught;

    public Staff() {
        super();
    }

    public Staff(String username, ContactDetails userContactDetails, String password, Set<CustomGrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, Name name) {
        super(username, userContactDetails, password, authorities, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, name);
    }

    public Set<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(Set<Conference> conferences) {
        this.conferences = conferences;
    }

    public Set<Designation> getDesignation() {
        return designation;
    }

    public void setDesignation(Set<Designation> designation) {
        this.designation = designation;
    }

    public String getSrn() {
        return srn;
    }

    public void setSrn(String srn) {
        this.srn = srn;
    }

    public StaffType getType() {
        return type;
    }

    public void setType(StaffType type) {
        this.type = type;
    }

    public String getDisplayName() {
        return super.getName().toString();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDateTime getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDateTime joiningDate) {
        this.joiningDate = joiningDate;
    }

    public LocalDateTime getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(LocalDateTime leavingDate) {
        this.leavingDate = leavingDate;
    }

    public AssociationType getAssociationType() {
        return associationType;
    }

    public void setAssociationType(AssociationType associationType) {
        this.associationType = associationType;
    }

    public Set<Qualification> getQualification() {
        return qualification;
    }

    public void setQualification(Set<Qualification> qualification) {
        this.qualification = qualification;
    }

    public Set<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(Set<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    @Override
    public String toString() {
        return "{" +
                "srn='" + srn + '\'' +
                ", department=" + department +
                ", type=" + type +
                ", joiningDate=" + joiningDate +
                ", leavingDate=" + leavingDate +
                ", associationType=" + associationType +
                ", qualification=" + qualification +
                ", designation=" + designation +
                '}';
    }

}
