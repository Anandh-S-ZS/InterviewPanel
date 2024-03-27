package com.zsgs.interviewpannel.interviewer;

import java.util.HashMap;
import java.util.List;

import com.zsgs.interviewpannel.database.InterviewDB;
import com.zsgs.interviewpannel.login.LoginView;
import com.zsgs.interviewpannel.model.InterviewPannel;

public class InterviewModel {
	
	InterviewDB db ;
	static InterviewModel im;
	static InterviewerView iv ;

	public static InterviewModel getInstance() {
		if(im == null)
			im = new InterviewModel();
		return im;
	}
	
	

	public void createInterviewer(String name, String password) {
		iv = InterviewerView.getInstance1();
		db = InterviewDB.getInstance();
		InterviewPannel hr = new InterviewPannel(name,password);
		db.getInterviewPannel().put(hr.getInterviewerId(), hr);
		db.setInterviewPannel();
		iv.onSuccess(hr.getInterviewerId());
	}


	public void addInterview(int id, String position) {
		db.getInterviewPannel().get(id).setPositionName(position);
		db.setInterviewPannel();
		LoginView.showAlert("Interview Added Successfully");
		iv.interviewerOptions();
	}


	public void interviewerLogin(int id, String password) {
		iv = InterviewerView.getInstance1();
		db = InterviewDB.getInstance();
		if(db.getInterviewPannel().containsKey(id))
		{
			if(db.getInterviewPannel().get(id).getInterviewerPassword().equals(password))
			{
				LoginView.showAlert("Login SuccessFul");
				iv.interviewerOptions();
			}
			else
			{
				LoginView.showAlert("I think your password is incorrect :/ ");
			}
		}
		else
		{
			LoginView.showAlert("Please Recheck Your ID please...");
		}
		iv.interviewerGetIn();
	}



	public void listAllCandidates(int id) {
		sortCandidate(id);
		System.out.println("----------------------------------");
		for(int c : db.getInterviewPannel().get(id).getCandidate())
		{
			LoginView.showAlert("Id			:"+db.getCandidate(c).getCandidateId()+
							  "\nName		:"	+db.getCandidate(c).getCandidateName()+
							  "\nCGPA		:"+	db.getCandidate(c).getGainedPercentage()+
							  "\nRating		:"+db.getCandidate(c).getCandidateRating()+
							  "\nReview		:"+db.getCandidate(c).getCandidateReview()); //c.getCandidateEmailId()+" \t"+
			System.out.println("----------------------------------");
		}
	}



	private void sortCandidate(int id) {
		int n = db.getInterviewPannel().get(id).getCandidate().size();
		List<Integer> ca = db.getInterviewPannel().get(id).getCandidate();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1-i;j++)
			{
				if(db.getCandidate(ca.get(j)).getCandidateRating() < db.getCandidate(ca.get(j+1)).getCandidateRating())
				{
					int temp = ca.get(j);
					System.out.println(temp);
					System.out.println("testing-----"+ca.get(j+1));
					ca.set(j, ca.get(j+1));
					ca.set(j+1,temp);
					db.getInterviewPannel().get(id).setCandidate(ca);
					db.setInterviewPannel();
				}
			}
		}
	}



	public void startInterview(int id) {
		System.out.println("uii");
		HashMap<Integer, InterviewPannel> interview = db.getInterviewPannel();
		System.out.println(interview.keySet());
		List<Integer> cand = interview.get(id).getCandidate();
		System.out.println(cand);
		for(int c : cand)
		{
			System.out.println(c);
			if(db.getCandidate(c).getCandidateRating() == 0)
			iv.interviewProcess(db.getCandidate(c).getCandidateId(),db.getCandidate(c).getCandidateName(),db.getCandidate(c).getCandidateEmailId(),db.getCandidate(c).getGainedPercentage());
		}
	}



	public void completeInterview(int candidateId, String inTime, String outTime, float rating, String review) {
		db.getCandidate(candidateId).setInterviewInTime(inTime);
		db.setCandidate();
		db.getCandidate(candidateId).setInterviewOutTime(outTime);
		db.setCandidate();
		db.getCandidate(candidateId).setCandidateRating(rating);
		db.setCandidate();
		db.getCandidate(candidateId).setCandidateReview(review);
		db.setCandidate();
	}
}
