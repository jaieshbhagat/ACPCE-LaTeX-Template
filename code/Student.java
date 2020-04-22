package org.acpce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.acpce.views.JsonViews;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student extends CustomUser {

	private static final long serialVersionUID = 7698256022852776091L;

    private Long prn;
    @OneToOne(cascade = CascadeType.ALL)
    private ParentDetails parentDetails;
    @OneToOne(cascade = CascadeType.ALL)
    private ResedentialAddress temporaryAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private ResedentialAddress permanentAddress;
    private MaritalStatus maritalStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private GovtIdDetails govtId;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER, mappedBy = "customUser")
    @JsonView(JsonViews.Level1.class)
    private Set<Designation> designations;
    private Gender gender;
    private BloodGroup bloodGroup;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String profilePicUri;
    @ManyToOne
    @JsonIgnore
    private Programme enrolledProgramme;

    public Long getPrn() {
        return prn;
    }

    public void setPrn(Long prn) {
        this.prn = prn;
    }

    public ParentDetails getParentDetails() {
		return parentDetails;
	}

	public void setParentDetails(ParentDetails parentDetails) {
		this.parentDetails = parentDetails;
	}

	public ResedentialAddress getTemporaryAddress() {
		return temporaryAddress;
	}

	public void setTemporaryAddress(ResedentialAddress temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}

	public ResedentialAddress getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(ResedentialAddress permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public GovtIdDetails getGovtId() {
		return govtId;
	}

	public void setGovtId(GovtIdDetails govtId) {
		this.govtId = govtId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
    }

    public String getProfilePicUri() {
        return profilePicUri;
    }

    public void setProfilePicUri(String profilePicUri) {
        this.profilePicUri = profilePicUri;
    }

    public Programme getEnrolledProgramme() {
        return enrolledProgramme;
    }

    public void setEnrolledProgramme(Programme enrolledProgramme) {
        this.enrolledProgramme = enrolledProgramme;
    }

    public String getExaminationName() {
        StringBuilder s = new StringBuilder();
        String a = super.getName().getLastName();
        if (a != null && !a.isEmpty())
            s.append(a);
        a = super.getName().getFirstName();
        if (a != null && !a.isEmpty())
            s.append(a);
        a = super.getName().getMiddleName();
        if (a != null && !a.isEmpty())
            s.append(a);
        a = parentDetails.getFathersName().getFirstName();
        if (a != null && !a.isEmpty())
            s.append(a);
        a = parentDetails.getMothersName().getFirstName();
        if (a != null && !a.isEmpty())
            s.append(a);
        return s.toString();
    }

    public Set<Designation> getDesignations() {
        return designations;
    }

    public void setDesignations(Set<Designation> designations) {
        this.designations = designations;
    }

    public Student() {
        super();
    }

}
