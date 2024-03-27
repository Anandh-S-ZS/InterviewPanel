package com.zsgs.interviewpannel.database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsgs.interviewpannel.model.Candidate;
import com.zsgs.interviewpannel.model.InterviewPannel;

public class InterviewDB {

	static InterviewDB interviewDb;
	ObjectMapper obj = new ObjectMapper();

	File candidateFile = new File(
			"C:\\Users\\abian\\eclipse-workspace\\InterviewPannel\\src\\com\\zsgs\\interviewpannel\\database\\candidates.json");
	File InterviewFile = new File(
			"C:\\Users\\abian\\eclipse-workspace\\InterviewPannel\\src\\com\\zsgs\\interviewpannel\\database\\interview.json");
	List<Candidate> candidate = new ArrayList<>();
	HashMap<Integer, InterviewPannel> interviewPannel = new HashMap<>();

	public static InterviewDB getInstance() {
		if (interviewDb == null)
			interviewDb = new InterviewDB();
		return interviewDb;
	}
//	HashMap<Integer, Candidate> candidate = new HashMap<>();

//	public HashMap<Integer, Candidate> getCandidate() {
//		return candidate;
//	}
	public HashMap<Integer, InterviewPannel> getInterviewPannel() {
		try {
			interviewPannel = obj.readValue(InterviewFile, new TypeReference<HashMap<Integer, InterviewPannel>>() {
			});
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println("Interview invoked");
		return interviewPannel;
	}

	public Candidate getCandidate(int id) {
		try {
			candidate = obj.readValue(candidateFile, new TypeReference<List<Candidate>>() {
			});
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println("candidate invoked");
		for (Candidate candid : candidate) {
			if (id == candid.getCandidateId()) {
				return candid;
			}
		}
		return null;
	}

	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}

	public void setCandidate() {
		try {
			obj.writeValue(candidateFile, candidate);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println("Candidate Updated");
	}

	public void setInterviewPannel(HashMap<Integer, InterviewPannel> interviewPannel) {
		this.interviewPannel = interviewPannel;
	}

	public void setInterviewPannel() {
		try {
			obj.writeValue(InterviewFile, interviewPannel);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println("Interview Updated");
	}

	public List<Candidate> getCandidates() {
		try {
			candidate = obj.readValue(candidateFile, new TypeReference<List<Candidate>>() {
			});
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return candidate;
	}
}
