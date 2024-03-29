package com.beimin.eveapi.corporation.member.tracking;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class MemberTrackingResponse extends ApiResponse {
	Set<ApiMember> members = new HashSet<ApiMember>();

	public void addMember(ApiMember member) {
		members.add(member);
	}

	public Set<ApiMember> getMembers() {
		return members;
	}
}
