package com.inahon;

import com.inahon.model.Doctor;
import com.inahon.model.Patient;
import com.inahon.repository.DoctorRepositoryImpl;
import com.inahon.repository.PatientRepositoryImpl;
import com.inahon.service.DoctorService;
import com.inahon.service.PatientService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        manageStaffs();

    }

    public static void manageStaffs() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        PatientRepositoryImpl patientRepository = new PatientRepositoryImpl(sessionFactory);
        PatientService patientService = new PatientService(patientRepository);
        DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl(sessionFactory);
        DoctorService doctorService = new DoctorService(doctorRepository);
        Scanner scanner = new Scanner(System.in);
        String choice1 = "Y";
        while (choice1.equalsIgnoreCase("Y")) {
        System.out.println("Please choose an option: ");
        System.out.println("-----------------------");
        System.out.println("1. Manage Patients: ");
        System.out.println("2. Manage Doctors: ");
        System.out.println("3. Manage Appointments: ");

        int option = scanner.nextInt();
        if (option == 1) {

            System.out.print("Choose a Service: ");
            System.out.println("---------------");

            System.out.println("1. Create Patient");
            System.out.println("2. Read Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");


            int choice = scanner.nextInt();




                try {
                    switch (choice) {
                        case 1:
                            // Application calls the service layer, not the repository directly
                            System.out.println("Create Patient");
                            Patient newPatient = new Patient();
                            scanner.nextLine();
                            System.out.print("Enter first name: ");
                            newPatient.setFirstName(scanner.nextLine());
                            System.out.print("Enter last name: ");
                            newPatient.setLastName(scanner.nextLine());
                            System.out.print("Enter date of birth (YYYY-MM-DD): ");
                            newPatient.setDateOfBirth(scanner.nextLine());
                            System.out.print("Enter email: ");
                            newPatient.setEmail(scanner.nextLine());
                            System.out.print("Enter phone number: ");
                            newPatient.setPhoneNumber(scanner.nextLine());
                            patientService.createPatient(newPatient);  // Use service here
                            System.out.println("Patient created successfully.");
                            break;
                        case 2:
                            // Application calls the service layer, not the repository directly
                            System.out.print("Enter Patient ID: ");
                            int patientId = scanner.nextInt();
                            Patient patient = patientService.getPatientById(patientId);  // Use service here
                            if (patient != null) {
                                System.out.println("Patient ID: " + patient.getPatientId());
                                System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
                                System.out.println("Date of Birth: " + patient.getDateOfBirth());
                                System.out.println("Email: " + patient.getEmail());
                                System.out.println("Phone: " + patient.getPhoneNumber());
                            } else {
                                System.out.println("Patient not found.");
                            }
                            break;
                        case 3:
                            // Application calls the service layer, not the repository directly
                            System.out.print("Enter Patient ID: ");
                            patientId = scanner.nextInt();
                            scanner.nextLine();  // consume newline
                            patient = patientService.getPatientById(patientId);  // Use service here
                            if (patient != null) {
                                System.out.print("Enter new first name: ");
                                patient.setFirstName(scanner.nextLine());
                                System.out.print("Enter new last name: ");
                                patient.setLastName(scanner.nextLine());
                                System.out.print("Enter new date of birth (YYYY-MM-DD): ");
                                patient.setDateOfBirth(scanner.nextLine());
                                System.out.print("Enter new email: ");
                                patient.setEmail(scanner.nextLine());
                                System.out.print("Enter new phone number: ");
                                patient.setPhoneNumber(scanner.nextLine());
                                patientService.updatePatient(patient);  // Use service here
                                System.out.println("Patient updated successfully.");
                            } else {
                                System.out.println("Patient not found.");
                            }
                            break;
                        case 4:
                            // Application calls the service layer, not the repository directly
                            System.out.print("Enter Patient ID: ");
                            patientId = scanner.nextInt();
                            patientService.deletePatient(patientId);  // Use service here
                            System.out.println("Patient deleted successfully.");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } finally {

                }
                System.out.println("Do you want to continue? (Y/N)");
                choice1 = scanner.next();

            }
            if (option == 2) {

                System.out.print("Choose a Service: ");
                System.out.println("---------------");

                System.out.println("1. Create Doctor");
                System.out.println("2. Read Doctor");
                System.out.println("3. Update Doctor");
                System.out.println("4. Delete Doctor");


                int choice = scanner.nextInt();

                try {
                    switch (choice) {
                        case 1:
                            // Application calls the service layer, not the repository directly
                            System.out.println("Create Doctor");
                            Doctor newDoctor = new Doctor();
                            scanner.nextLine();
                            System.out.print("Enter First Name: ");
                            newDoctor.setFirstName(scanner.nextLine());
                            System.out.print("Enter Last Name: ");
                            newDoctor.setLastName(scanner.nextLine());
                            System.out.print("Enter Specialty: ");
                            newDoctor.setSpeciality(scanner.nextLine());
                            System.out.print("Enter email: ");
                            newDoctor.setEmail(scanner.nextLine());
                            doctorService.createDoctor(newDoctor);  // Use service here
                            System.out.println("Doctor created successfully.");
                            break;
                        case 2:
                            // Application calls the service layer, not the repository directly
                            System.out.print("Enter Doctor ID: ");
                            int doctorId = scanner.nextInt();
                           Doctor doctor = doctorService.getDoctorById(doctorId);  // Use service here
                            if (doctor != null) {
                                System.out.println("Doctor ID: " + doctor.getDoctorId());
                                System.out.println("Name: " + doctor.getFirstName() + " " + doctor.getLastName());
                                System.out.println("Specialty: " + doctor.getSpeciality());
                                System.out.println("Email: " + doctor.getEmail());
                            } else {
                                System.out.println("Doctor not found.");
                            }
                            break;
                        case 3:
                            // Application calls the service layer, not the repository directly
                            System.out.print("Enter Doctor ID: ");
                            doctorId = scanner.nextInt();
                            scanner.nextLine();  // consume newline
                            doctor = doctorService.getDoctorById(doctorId);  // Use service here
                            if (doctor != null) {
                                System.out.print("Enter new first name: ");
                                doctor.setFirstName(scanner.nextLine());
                                System.out.print("Enter new last name: ");
                                doctor.setLastName(scanner.nextLine());
                                System.out.print("Enter new Specialty: ");
                                doctor.setSpeciality(scanner.nextLine());
                                System.out.print("Enter new email: ");
                                doctor.setEmail(scanner.nextLine());
                                doctorService.updateDoctor(doctor);  // Use service here
                                System.out.println("Doctor updated successfully.");
                            } else {
                                System.out.println("Doctor not found.");
                            }
                            break;
                        case 4:
                            // Application calls the service layer, not the repository directly
                            System.out.print("Enter Doctor ID: ");
                            doctorId = scanner.nextInt();
                            doctorService.deleteDoctor(doctorId);  // Use service here
                            System.out.println("Doctor deleted successfully.");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } finally {

                }
                System.out.println("Do you want to continue? (Y/N)");
                choice1 = scanner.next();

            }
            System.out.println("Good bye!");

        }

        scanner.close();
        sessionFactory.close();
    }
}