package com.zsgs.interviewpannel.interviewer;

import java.time.LocalTime;
import java.util.Scanner;

import com.zsgs.interviewpannel.login.LoginView;

public class InterviewerView {
	Scanner sc = new Scanner(System.in);
	
	static InterviewerView iv ;
	InterviewModel im;
	static int id;
	
	public static InterviewerView getInstance1() {
		if(iv==null)
			iv = new InterviewerView();
		return iv;
	}

	public void interviewerGetIn() {
		im = InterviewModel.getInstance();
		System.out.println("1.SignUp || 2.LogIn || 0.Exit");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			interviewerSignUp();
			break;
		case 2:
			interviewerLogin();
			break;
		case 0:
			break;
		}
		if(choice != 0)
		{
			interviewerGetIn();
		}
	}

	private void interviewerLogin() {
		System.out.println("Enter Login Details");
		System.out.println("Enter Your ID:");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Your Password:");
		String password = sc.nextLine();
		im.interviewerLogin(id,password);
	}

	private void interviewerSignUp() {
		
		sc.nextLine();
		System.out.println("Enter Your Details to SignUp");
		System.out.println("Enter Interviewer Name:");
		String name = sc.nextLine();
		System.out.println("Enter Your Password:");
		String password = sc.nextLine();
		im.createInterviewer(name, password);
	}

	public void onSuccess(int id) {
		InterviewerView.id = id;
		System.out.println("Sign Up Completed!");
		System.out.println("Your Id is :"+id);
		addInterview(id);
	}

	private void addInterview(int id) {
		System.out.println("\nEnter Topic of Interview:");
		String position = sc.nextLine();
		im.addInterview(id,position);
	}

	public void interviewerOptions() {
		System.out.println("1.Start Interview || 2.List All Candidates || 0.Log Out");
		//Thread.dumpStack();
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			im.startInterview(id);
			//todo: 1.next Candidate || 2.from Id @ V 2.0
			break;
		case 2:
			im.listAllCandidates(id);
			break;
		case 0:
			break;
		default:
			LoginView.showAlert("Invalid Input");
		}
		if(choice !=0)
		{
			interviewerOptions();
		}
	}

	public LocalTime getTime() {
		String time = sc.nextLine();
		String[] t1 = time.split(":");
		LocalTime t = LocalTime.of(Integer.parseInt(t1[0]), Integer.parseInt(t1[1]));
		return t;
	}
	

	public void interviewProcess(int candidateId, String candidateName, String candidateEmailId,
			double gainedPercentage) {
		LoginView.showAlert("---------------------------------------------");
		LoginView.showAlert("ID:\t"+candidateId+" \n"+
				"Name:\t"+candidateName+" \n"+
				"Email:\t"+candidateEmailId+" \n"+
				"CGPA:\t"+gainedPercentage);
		sc.nextLine();
		LoginView.showAlert("\nEnter In Time[HH:MM]:");
		String inTime = sc.next();
		LoginView.showAlert("\nEnter Out Time[HH:MM]:");
		String outTime = sc.next();
		LoginView.showAlert("Enter Rating:");
		float rating = sc.nextFloat();
		sc.nextLine();
		LoginView.showAlert("Enter Review:");
		String review = sc.nextLine();
		im.completeInterview(candidateId,inTime,outTime,rating,review);
	}

}
