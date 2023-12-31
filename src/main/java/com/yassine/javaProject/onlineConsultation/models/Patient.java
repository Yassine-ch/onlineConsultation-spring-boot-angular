package com.yassine.javaProject.onlineConsultation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "first name is required!")
    @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters")
    private String firstName;

    @NotEmpty(message = "last name is required!")
    @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters")
    private String lastName;

    @NotEmpty(message = "Email is required!")
    @Email(message = "Please enter a valid email!")
    private String email;

    @NotEmpty(message = "Password is required!")
    @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
    private String password;

    @Transient
    @NotEmpty(message = "Confirm Password is required!")
    @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
    private String confirm;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
//M.M
//@JsonIgnore
//    //M:M
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "allConsultation",
//            joinColumns = @JoinColumn(name = "patient_id"),
//            inverseJoinColumns = @JoinColumn(name="doctor_id"))
//    private List <Doctor> doctors;
// Review One To Many

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Review> patientReviews;
    // Consultation One To Many

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Consultation> patientConsultations;

    // Prescription One To Many


    public List<Review> getPatientReviews() {
        return patientReviews;
    }

    public void setPatientReviews(List<Review> patientReviews) {
        this.patientReviews = patientReviews;
    }
    @JsonIgnore
    public List<Consultation> getPatientConsultations() {
        return patientConsultations;
    }

    public void setPatientConsultations(List<Consultation> patientConsultations) {
        this.patientConsultations = patientConsultations;
    }

    public List<Prescription> getPatientPrescriptions() {
        return patientPrescriptions;
    }

    public void setPatientPrescriptions(List<Prescription> patientPrescriptions) {
        this.patientPrescriptions = patientPrescriptions;
    }

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Prescription> patientPrescriptions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


}