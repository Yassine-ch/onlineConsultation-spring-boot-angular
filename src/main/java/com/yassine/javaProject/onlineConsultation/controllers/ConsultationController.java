//package com.yassine.javaProject.onlineConsultation.controllers;
//
//import com.yassine.javaProject.onlineConsultation.models.Consultation;
//import com.yassine.javaProject.onlineConsultation.models.Doctor;
//import com.yassine.javaProject.onlineConsultation.models.Patient;
//import com.yassine.javaProject.onlineConsultation.repositories.ConsultationRepository;
//import com.yassine.javaProject.onlineConsultation.repositories.DoctorRepository;
//import com.yassine.javaProject.onlineConsultation.repositories.PatientRepository;
//import com.yassine.javaProject.onlineConsultation.services.ConsultationService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ConsultationController {
//
//    @Autowired
//    private ConsultationService consultationService;
//
////     Create One Consultation
//    @PostMapping(value = "/consultations/create")
//    public
//    Consultation createConsultation(
//            @RequestBody Consultation consultation ,@PathVariable("id") Long doctorID)
//    {
//        Consultation consultationCreated = consultationService.create(consultation);
////        return new ResponseEntity<>(consultationCreated, HttpStatus.CREATED);
//        return consultationService.addConsultationWithDoctorID(consultation, doctorID);
//    }
//    ///*/*/*/*/* CONSULATATION WITH DOCTOR ID
//
//    @PostMapping("/consultation/create")
//    public Consultation addConsultationWithDoctorId(
//            @RequestBody Consultation cc,
//            @PathVariable("doctorID") Long doctorID)
//    {
//        return consultationService.addConsultationWithDoctorID(cc, doctorID);
//    }
//    @GetMapping("/consultations/byPatient/{patientId}")
//    public List<Consultation> getConsultationsByPatientId(@PathVariable Long patientId) {
//        return consultationService.findConsultationsByPatientId(patientId);
//    }
//    //Get Consultation with doctor and patient IDs
//
////    @GetMapping("/consultations{patientId}/{doctorId}")
////    public List<Consultation> getConsultationsByPatientAndDoctor(
////            @RequestParam("patientId") Long patientId,
////            @RequestParam("doctorId") Long doctorId) {
////        return consultationService.findConsultationsByPatientAndDoctor(patientId, doctorId);
////    }
////     Get All Consultations
//    @GetMapping("/consultations")
//    public ResponseEntity<List<Consultation>> getAllConsultations() {
//        List<Consultation> allConsultations = consultationService.findAllConsultation();
//        return new ResponseEntity<>(allConsultations, HttpStatus.OK);
//    }
//
//    // Find One Consultation
//    @GetMapping("/consultations/{id}")
//    public ResponseEntity<Consultation> getOneConsultation(@PathVariable Long id) {
//        Consultation oneConsultation = consultationService.findOneById(id);
//        return new ResponseEntity<>(oneConsultation, HttpStatus.OK);
//    }
//
//    // Update One Consultation
//    @PutMapping("/consultations/{id}")
//    public ResponseEntity<Consultation> updateOneConsultation(@PathVariable Long id, @RequestBody Consultation consultation) {
//        Consultation existingConsultation = consultationService.findOneById(id);
//        if (existingConsultation != null) {
//            existingConsultation.setStatus(consultation.getStatus());
//            existingConsultation.setStartTime(consultation.getStartTime());
//            existingConsultation.setEndTime(consultation.getEndTime());
//            existingConsultation.setConcerns(consultation.getConcerns());
//            Consultation updatedConsultation = consultationService.update(consultation);
//            return new ResponseEntity<>(updatedConsultation, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Delete a consultation by ID
//    @DeleteMapping("/consultations/{id}")
//    public ResponseEntity<Consultation> deleteConsultation(@PathVariable Long id) {
//        consultationService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//    //-*-**--*-*-*/*/*/--**/-
//
//
//
//        @Autowired
//        private ConsultationRepository consultationRepository;
//
//        @Autowired
//        private DoctorRepository doctorRepository;
//
//        @Autowired
//        private PatientRepository patientRepository;
//
//        @PostMapping("/add")
//        public ResponseEntity<Consultation> addConsultation(@RequestBody ConsultationRequest request) {
//            Doctor doctor = doctorRepository.findById(request.getDoctorId()).orElse(null);
//            Patient patient = patientRepository.findById(request.getPatientId()).orElse(null);
//
//            if (doctor == null || patient == null) {
//                return ResponseEntity.badRequest().build();
//            }
//
//            Consultation consultation = new Consultation();
//            consultation.setStatus(request.getStatus());
//            consultation.setStartTime(request.getStartTime());
//            consultation.setEndTime(request.getEndTime());
//            consultation.setConcerns(request.getConcerns());
//            consultation.setDiseases(request.getDiseases());
//            consultation.setDoctor(doctor);
//            consultation.setPatient(patient);
//
//            consultationRepository.save(consultation);
//
//            return ResponseEntity.ok(consultation);
//        }
//    }
//
//    class ConsultationRequest {
//        private Long doctorId;
//        private Long patientId;
//        private String status;
//        private Date startTime;
//        private Date endTime;
//        private String concerns;
//        private String diseases;
//        // getters and setters
//
//        public Long getDoctorId() {
//            return doctorId;
//        }
//
//        public void setDoctorId(Long doctorId) {
//            this.doctorId = doctorId;
//        }
//
//        public Long getPatientId() {
//            return patientId;
//        }
//
//        public void setPatientId(Long patientId) {
//            this.patientId = patientId;
//        }
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        public Date getStartTime() {
//            return startTime;
//        }
//
//        public void setStartTime(Date startTime) {
//            this.startTime = startTime;
//        }
//
//        public Date getEndTime() {
//            return endTime;
//        }
//
//        public void setEndTime(Date endTime) {
//            this.endTime = endTime;
//        }
//
//        public String getConcerns() {
//            return concerns;
//        }
//
//        public void setConcerns(String concerns) {
//            this.concerns = concerns;
//        }
//
//        public String getDiseases() {
//            return diseases;
//        }
//
//        public void setDiseases(String diseases) {
//            this.diseases = diseases;
//        }
//    }
//
//
package com.yassine.javaProject.onlineConsultation.controllers;

import com.yassine.javaProject.onlineConsultation.models.Consultation;
import com.yassine.javaProject.onlineConsultation.models.Doctor;
import com.yassine.javaProject.onlineConsultation.models.Patient;
import com.yassine.javaProject.onlineConsultation.services.ConsultationService;
import com.yassine.javaProject.onlineConsultation.services.DoctorService;
import com.yassine.javaProject.onlineConsultation.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    // Create a new consultation
    @PostMapping
    public ResponseEntity<Consultation> createConsultation(@RequestBody Consultation consultation) {
        return ResponseEntity.ok(consultationService.create(consultation));
    }

    // Get all consultations
    @GetMapping
    public ResponseEntity<List<Consultation>> getAllConsultations() {
        return ResponseEntity.ok(consultationService.findAllConsultation());
    }

    // Update a consultation
    @PutMapping("/{id}")
    public ResponseEntity<Consultation> updateConsultation(@PathVariable Long id, @RequestBody Consultation consultation) {
        if(!id.equals(consultation.getId())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(consultationService.update(consultation));
    }

    // Delete a consultation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable Long id) {
        consultationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Get consultation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable Long id) {
        Consultation consultation = consultationService.findOneById(id);
        if (consultation != null) {
            return ResponseEntity.ok(consultation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get consultations by patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Consultation>> getConsultationsByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(consultationService.findConsultationsByPatientId(patientId));
    }

    // Add consultation with doctor ID
    @PostMapping("/withDoctor/{doctorId}/{patientId}")
    public ResponseEntity<Consultation> addConsultationWithDoctor(@RequestBody Consultation consultation,
                                                                  @PathVariable Long doctorId ,
                                                                  @PathVariable Long patientId) {
        Doctor doctor= doctorService.findDoctor((Long) doctorId);
        Patient patient= patientService.findPatient((Long) patientId);

        consultation.setDoctor(doctor);
        consultation.setPatient(patient);
        Consultation consultationCreated = consultationService.create(consultation);
return new ResponseEntity<>(consultationCreated, HttpStatus.CREATED);    }

    // Add a consultation with details
//     This endpoint requires more detailed input, perhaps you can adjust this endpoint to suit your needs, or use a DTO to collect the necessary information.
//    @PostMapping("/detailed")
//    public ResponseEntity<Consultation> addDetailedConsultation(@RequestBody ConsultationDetailsDTO consultationDetails) {
//        Doctor doctor = /* fetch or create Doctor from consultationDetails */;
//        Patient patient = /* fetch or create Patient from consultationDetails */;
//        Consultation consultation = consultationService.addConsultation( doctor, patient, consultationDetails.getStatus(),
//                consultationDetails.getStartTime(), consultationDetails.getEndTime(),
//                consultationDetails.getConcerns(), consultationDetails.getDiseases());
//        return ResponseEntity.ok(consultation);
//    }
}
