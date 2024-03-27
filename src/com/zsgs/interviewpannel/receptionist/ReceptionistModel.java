package com.zsgs.interviewpannel.receptionist;

import java.time.LocalTime;
import java.util.List;

import com.zsgs.interviewpannel.database.InterviewDB;
import com.zsgs.interviewpannel.login.LoginView;
import com.zsgs.interviewpannel.model.Candidate;

public class ReceptionistModel {
	
	static ReceptionistModel receptionistModel;
	static ReceptionistView rv ;
	static InterviewDB db;
	
	
	public static ReceptionistModel getInstance() {
		if(receptionistModel == null)
			receptionistModel = new ReceptionistModel();
		return receptionistModel;
	}
	

	public void isValidReceptionist(int id, String password) {
		rv = ReceptionistView.getInstance();
		db  = InterviewDB.getInstance();
		if(isValidId(id))
		{
			System.out.println("Id Matched");
			if(isValidPassword(password))
			{
				LoginView.showAlert("Password Matched\nWelcome");
				rv.receptionistOptions();
			}
		}
	}

	private static boolean isValidPassword(String password) {
		return password.equals("Godzilla");
	}

	private static boolean isValidId(int id) {
		return id == 777;
	}

	public LocalTime convertTime(String next) {
		String[] time = next.split(":");
		int h = Integer.parseInt(time[0]);
		int m = Integer.parseInt(time[1]);
		LocalTime t = LocalTime.of(h, m);
		return t;
	}

	public void createCandidate(String name, String email, double mark, String dept, int id, String time) {
		Candidate c = new Candidate(name,email,mark,dept,id,time);
		db.getCandidates().add(c);
		db.setCandidate();
		List<Integer> c1 = db.getInterviewPannel().get(id).getCandidate();
		c1.add(c.getCandidateId());
		db.setCandidate();
		db.setInterviewPannel();
		rv.addCandidate();
	}


	public void checkInterview() {
		if(!db.getInterviewPannel().isEmpty())
		{
			rv.addCandidateDetails();
		}
		else {
			LoginView.showAlert("Interview Is Not Available Right Now");
			rv.candidateOptions();
		}
	}


	public void listAllInterviews() {
		LoginView.showAlert("---------------------------------");
		for(int i : db.getInterviewPannel().keySet())
		{
			LoginView.showAlert("Interview Id	:"+db.getInterviewPannel().get(i).getInterviewerId()+
							  "\nPosition	:"+db.getInterviewPannel().get(i).getPositionName()+
							  "\nInterviewer	:"+db.getInterviewPannel().get(i).getInterviewerName());
			LoginView.showAlert("---------------------------------");
		}
	}


	public void setCandidateName(String name, int id) {
		db.getCandidate(id).setCandidateName(name);
		db.setCandidate();
		LoginView.showAlert("Name Updated SuccessFully");
	}


	public void setCandidateEmail(String email, int id) {
		db.getCandidate(id).setCandidateEmailId(email);
		db.setCandidate();
		LoginView.showAlert("Email Updated SuccessFully");
	}


	public void setCandidateCGPA(double cgpa, int id) {
		db.getCandidate(id).setGainedPercentage(cgpa);
		db.setCandidate();
		LoginView.showAlert("CGPA Updated SuccessFully");
	}


	public void listAllInterviews(int i) {
		LoginView.showAlert("---------------------------------");
		for(int e : db.getInterviewPannel().keySet())
		{
			LoginView.showAlert("Interview Id	:"+db.getInterviewPannel().get(e).getInterviewerId()+
					  "\nInterviewer	:"+db.getInterviewPannel().get(e).getInterviewerName());}
			LoginView.showAlert("---------------------------------");
	}


	public void listAllCandidates() {
		LoginView.showAlert("---------------------------------");
		for(Candidate cd  : db.getCandidates())
		{
			LoginView.showAlert("Candidate Id	:"+cd.getCandidateId()+
							  "\nCandidate Name	:"+cd.getCandidateName()+
							  "\nCGPA		:"+cd.getGainedPercentage()+
							  "\nDept		:"+cd.getDegree()+
							  "\nPannel Id	:"+cd.getInterviewPannelId()+
							  "\nIn Time		:"+cd.getArrivalTime());
			LoginView.showAlert("---------------------------------");
		}
	}


	public void deleteCandidate(int id) {
		db.getCandidates().remove(db.getCandidate(id));
		db.setCandidate();
		LoginView.showAlert("Candidate Removed Successfully");
	}


	public Candidate getCandidate(int id) {
		if(db.getCandidate(id) != null)
		{
			return db.getCandidate(id);
		}
		LoginView.showAlert("Candidate Not available");
		return null;
	}


	public boolean checkInterview(int id) {
		if(db.getInterviewPannel().containsKey(id))
			return false;
		LoginView.showAlert("Interview Id not available");
		return true;
	}
}
