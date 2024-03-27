package com.zsgs.interviewpannel.login;

import java.util.Scanner;

import com.zsgs.interviewpannel.InterviewPannelInfo;
import com.zsgs.interviewpannel.interviewer.InterviewerView;
import com.zsgs.interviewpannel.receptionist.ReceptionistView;

public class LoginView {
	
	
	private static LoginView lv;
	Scanner sc = new Scanner(System.in);
	
	public static LoginView getInstance() {
		if(lv == null)
			lv = new LoginView();
		return lv;
	}
	

	
	public void init() {
		System.out.println("--- "+ InterviewPannelInfo.getInstance().getAppName() + " --- \nversion "+ 
				InterviewPannelInfo.getInstance().getAppVersion());
		loginOption();

	}

	public void loginOption() {
		System.out.println("1.Receptionist || 2.Interviewer || 3.ShutDown");
		int choice = sc.nextInt();
		sc.nextLine();
		if(choice == 1)
		{
			ReceptionistView.getInstance().receptionistLogin();
		}
		else if(choice == 2)
		{
			InterviewerView.getInstance1().interviewerGetIn();
		}
		else if(choice == 3)
		{
			showAlert("Shuting Down...!");
			System.exit(0);
		}
		else {
			showAlert("Invalid Input...!");
			
		}
		loginOption();
	}
	public void onSuccess() {
		System.out.println("\n\n Login successful...\n\n ---- Welcome to "+InterviewPannelInfo.getInstance().getAppName());
	}

	public static void showAlert(String string) {
		System.out.println(string);
	}
	
	
}
