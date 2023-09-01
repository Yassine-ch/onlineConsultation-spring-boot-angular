package com.yassine.javaProject.onlineConsultation.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "first name is required!")
    @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters")
    private String firstName;

    @NotEmpty(message = "last name is required!")
    @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters")
    private String lastName;

    @NotEmpty(message = "proficiency is required!")
    @Size(min = 3, max = 30, message = "proficiency must be between 3 and 30 characters")
    private String proficiency;

    @NotNull(message = "price is required.")
    private Integer price;

    @NotEmpty(message = "Email is required!")
    @Email(message = "Please enter a valid email!")
    private String email;

    @NotEmpty(message = "Password is required!")
    @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
    private String password;

    @Transient
    @NotEmpty(message = "Confirm Password is required!")
    @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
    private String confirmPassword;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    // Review One To Many



    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Review> doctorReviews;

    // Consultation One To Many

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)

    private List<Consultation> doctorConsultations;

    // Prescription One To Many

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Prescription> doctorPrescriptions;

    // Address Many to One

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="address_id")

    private Address address;

    public Doctor() {

    }

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

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }
    @JsonIgnore

    public List<Consultation> getDoctorConsultations() {
        return doctorConsultations;
    }

    public void setDoctorConsultations(List<Consultation> doctorConsultations) {
        this.doctorConsultations = doctorConsultations;
    }


    public List<Prescription> getDoctorPrescriptions() {
        return doctorPrescriptions;
    }

    public void setDoctorPrescriptions(List<Prescription> doctorPrescriptions) {
        this.doctorPrescriptions = doctorPrescriptions;
    }


    public List<Review> getDoctorReviews() {
        return doctorReviews;
    }

    public void setDoctorReviews(List<Review> doctorReviews) {
        this.doctorReviews = doctorReviews;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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