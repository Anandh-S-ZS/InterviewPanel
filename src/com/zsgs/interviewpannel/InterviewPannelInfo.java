package com.zsgs.interviewpannel;

public class InterviewPannelInfo {
	private static InterviewPannelInfo interviewPannelInfo;
	
	private String appName = "Interview Management System";
	
	private String appVersion = "0.0.1";
	
	private InterviewPannelInfo() {
		
	}
	
	public static InterviewPannelInfo getInstance() {
		if(interviewPannelInfo == null)
		{
			interviewPannelInfo = new InterviewPannelInfo();
		}
		return interviewPannelInfo;
	}

	public String getAppName() {
		return appName;
	}

	public String getAppVersion() {
		return appVersion;
	}
}
