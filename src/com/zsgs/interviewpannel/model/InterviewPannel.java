package com.zsgs.interviewpannel.model;

import java.util.ArrayList;
import java.util.List;

public class InterviewPannel {
	private static int idCreater = 1001;
	private String positionName;
	private int interviewerId;
	private String interviewerName;
	private String interviewerPassword;
	private List<Integer> candidateYetToComplete = new ArrayList<>();
	private List<Integer> candidateCompleted = new ArrayList<>();
	
	public InterviewPannel(String name, String password)
	{
		this.interviewerName = name;
		this.interviewerPassword = password;
		this.interviewerId = idCreater++;
	}
	
	public InterviewPannel() {
		
	}
	
	public String getPositionName() {
		return positionName;
	}
	public int getInterviewerId() {
		return interviewerId;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public void setInterviewerId(int interviewerId) {
		this.interviewerId = interviewerId;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public List<Integer> getCandidate() {
		return candidateYetToComplete;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public void setCandidate(List<Integer> candidate) {
		this.candidateYetToComplete = candidate;
	}
	public String getInterviewerPassword() {
		return interviewerPassword;
	}
	public void setInterviewerPassword(String interviewerPassword) {
		this.interviewerPassword = interviewerPassword;
	}

	public List<Integer> getCandidateCompleted() {
		return candidateCompleted;
	}

	public void setCandidateCompleted(List<Integer> candidateCompleted) {
		this.candidateCompleted = candidateCompleted;
	}
	
}
