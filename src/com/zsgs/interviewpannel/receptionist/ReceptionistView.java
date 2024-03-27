package com.zsgs.interviewpannel.receptionist;

import java.util.Scanner;

import com.zsgs.interviewpannel.login.LoginView;
import com.zsgs.interviewpannel.model.Candidate;

public class ReceptionistView {
	static ReceptionistView receptionist;
	Scanner sc = new Scanner(System.in);
	LoginView lv ;
	ReceptionistModel rm ;
	
	
	public static ReceptionistView getInstance() {
		if(receptionist == null)
		{
			receptionist = new ReceptionistView();
		}
		return receptionist;
	}
	
	public void receptionistLogin() {
		rm = ReceptionistModel.getInstance();
		lv = LoginView.getInstance();
		System.out.println("Hello Receptionist..!");
		System.out.println("Enter Id & Password to continue:");
		System.out.println("Enter Id:");
		int id = sc.nextInt();
		System.out.println("Enter Password:");
		String password = sc.next();
		rm.isValidReceptionist(id,password);
	}

	public void receptionistOptions() {
		System.out.println("1.Candidate Record || 2.List All Interviews || 3.List All HRs || 0.Logout");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			candidateOptions();
			break;
		case 2:
			rm.listAllInterviews();
			break;
		case 3:
			rm.listAllInterviews(0);
			break;
		case 0:
			//lv.loginOption();
			break;
		default:
			LoginView.showAlert("Invalid Input");
			
		}
		if(choice !=0)
		{
			receptionistOptions();
		}
	}
	
	public void candidateOptions() {
		System.out.println("1.Add Candidate || 2.Edit Candidate || 3.Delete Candidate || 4.List All Candidate || 0.Exit");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			rm.checkInterview();
			break;
		case 2:
			editCandidateDetails();
			break;
		case 3:
			deleteCandidateDetails();
			break;
		case 4:
			listCandidateDetails();
			break;
		case 0:
			break;
		default:
			candidateOptions();
		}
		if(choice !=0)
		{
			candidateOptions();
		}
	}

	private void listCandidateDetails() {
		rm.listAllCandidates();
	}

	private void deleteCandidateDetails() {
		System.out.println("Enter Candidate Id:");
		int id = sc.nextInt();
		showCandidate(id);
		System.out.println("Are You Sure to Delete[y/n]?");
		char choice = sc.next().charAt(0);
		switch(choice)
		{
		case 'y':
			rm.deleteCandidate(id);
			break;
		case 'n':
			System.out.println("Candidate Delete process stoped...!");
		}
		candidateOptions();
	}
	
	private void showCandidate(int id) {
		Candidate c = rm.getCandidate(id);
		if(c!=null)
		{
			System.out.println(c.getCandidateId()+" \t|| "+c.getCandidateName()+" \t|| "+c.getCandidateEmailId());
		}
	}

	private void editCandidateDetails() {
		System.out.println("Enter Candidate Id:");
		int id = sc.nextInt();
		System.out.println("Which Info You Trying to edit:");
		System.out.println("1.Candidate Name || 2.Candidate Email Id || 3.Gained CGPA || 0.Go Back");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			setCandidateName(id);
			break;
		case 2:
			setCandidateEmail(id);
			break;
		case 3:
			setGainedCGPA(id);
			break;
		case 0:
			candidateOptions();
			break;
		default:
			LoginView.showAlert("Invalid Input");
			editCandidateDetails();
		}
	}
	
	private void setGainedCGPA(int id) {
		System.out.println("Enter CGPA:");
		double cgpa = sc.nextDouble();
		rm.setCandidateCGPA(cgpa, id);
	}

	private void setCandidateEmail(int id) {
		sc.nextLine();
		System.out.println("Enter EmailID:");
		String email = sc.nextLine();
		rm.setCandidateEmail(email, id);
	}

	private void setCandidateName(int id) {
		sc.nextLine();
		System.out.println("Enter Candidate name:");
		String name = sc.nextLine();
		rm.setCandidateName(name, id);
	}

	void addCandidateDetails() {
		sc.nextLine();
		System.out.println("Enter Candidate Name:");
		String name = sc.nextLine();
		System.out.println("Enter Email Id:");
		String email = sc.nextLine();
		System.out.println("Enter Department:");
		String dept = sc.nextLine();
		System.out.println("Enter CGPA:");
		double mark = sc.nextDouble();
		rm.listAllInterviews();
		int id;
		
		do {
		System.out.println("Enter InterView ID:");
		id = sc.nextInt();
		
		}while(rm.checkInterview(id));
		
		System.out.println("Enter Arrived Time[HH:MM] :");
		String time = sc.next();
		rm.createCandidate(name,email,mark,dept,id,time);
		
	}

	public void addCandidate() {
		System.out.println("Is There Next Candidate[y/n]?");
		char c = sc.next().charAt(0);
		switch(c)
		{
		case 'y':
			addCandidateDetails();
			break;
		case 'n':
			break;
		default:
			addCandidate();
		}
	}
	
	

}
