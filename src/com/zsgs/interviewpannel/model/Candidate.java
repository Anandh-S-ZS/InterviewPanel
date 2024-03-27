package com.zsgs.interviewpannel.model;

public class Candidate {
	private static int idGenerater = 101;
	private int candidateId;
	private String candidateName;
	private String candidateEmailId;
	private double gainedPercentage;
	private int interviewPannelId;
	private String degree;
	private String arrivalTime;
	private String interviewInTime;
	private String interviewOutTime;
	private float candidateRating;
	private String candidateReview;
	
	public Candidate() {
		
	}
	
	
	public Candidate(String name, String email, double mark, String degree, int interviewId, String arrivalTime) {
		this.candidateName = name;
		this.candidateEmailId = email;
		this.gainedPercentage = mark;
		this.degree = degree;
		this.interviewPannelId = interviewId;
		this.arrivalTime = arrivalTime;
		this.candidateId = idGenerater++;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public String getCandidateEmailId() {
		return candidateEmailId;
	}
	public int getInterviewPannelId() {
		return interviewPannelId;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public String getInterviewInTime() {
		return interviewInTime;
	}
	public String getInterviewOutTime() {
		return interviewOutTime;
	}
	public float getCandidateRating() {
		return candidateRating;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public void setCandidateEmailId(String candidateEmailId) {
		this.candidateEmailId = candidateEmailId;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setInterviewInTime(String inTime) {
		interviewInTime = inTime;
	}
	public void setInterviewOutTime(String outTime) {
		interviewOutTime = outTime;
	}
	public void setCandidateRating(float candidateRating) {
		this.candidateRating = candidateRating;
	}
	public double getGainedPercentage() {
		return gainedPercentage;
	}
	public void setGainedPercentage(double gainedPercentage) {
		this.gainedPercentage = gainedPercentage;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getCandidateReview() {
		return candidateReview;
	}
	public void setCandidateReview(String candidateReview) {
		this.candidateReview = candidateReview;
	}
}
