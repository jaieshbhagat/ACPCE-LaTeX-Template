package org.acpce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AcpceOAuth2User implements OAuth2User {

    private String id;
    private String username;
    private String profilePicUri;
    private Name name;
    private Set<CustomGrantedAuthority> authorities;
    private Map<String, Object> attributes;
    private ContactDetails userContactDetails;
    private Set<Designation> designation;
    private Department department;
    private LocalDate joiningDate;
    private StaffType type;

    public AcpceOAuth2User() {
        super();
    }

    @Override
    public Map<String, Object> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new HashMap<>();
            this.attributes.put("id", this.getId());
            this.attributes.put("profilePicUri", this.getProfilePicUri());
            this.attributes.put("firstName", this.name.getFirstName());
            this.attributes.put("middleName", this.name.getMiddleName());
            this.attributes.put("lastName", this.name.getLastName());
            this.attributes.put("displayName", this.name.toString());
            this.attributes.put("username", this.getName());
            this.attributes.put("primaryMail", this.getUserContactDetails().getPrimaryMail());
            this.attributes.put("secondaryMail", this.getUserContactDetails().getSecondaryMail());
            this.attributes.put("mobile", this.getUserContactDetails().getMobile());
            this.attributes.put("designation", this.getDesignation());
            this.attributes.put("department", this.getDepartment());
            this.attributes.put("type", this.getType());
            this.attributes.put("joiningDate", this.getJoiningDate());
        }
        return attributes;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public StaffType getType() {
        return type;
    }

    public void setType(StaffType type) {
        this.type = type;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Designation> getDesignation() {
        return designation;
    }

    public void setDesignation(Set<Designation> designation) {
        this.designation = designation;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public ContactDetails getUserContactDetails() {
        return userContactDetails;
    }

    public void setUserContactDetails(ContactDetails userContactDetails) {
        this.userContactDetails = userContactDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return authorities.stream().map(customGrantedAuthority -> new SimpleGrantedAuthority(customGrantedAuthority.getAuthority())).collect(Collectors.toSet());
        return authorities;
    }

    public void setAuthorities(Set<CustomGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getName() {
        return username;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicUri() {
        return profilePicUri;
    }

    public void setProfilePicUri(String profilePicUri) {
        this.profilePicUri = profilePicUri;
    }

}
