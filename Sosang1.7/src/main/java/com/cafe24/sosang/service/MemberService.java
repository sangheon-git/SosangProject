package com.cafe24.sosang.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.cafe24.sosang.dto.MemberDTO;
import com.cafe24.sosang.dto.MylogDTO;

public interface MemberService {

	// 아이디중복체크
	public int userIdCheck(String id) throws Exception;

	// 이메일중복체크
	public int check_email(String email) throws Exception;
	
	// 회원 정보 수정 : 이메일중복체크
	public int check_email2(MemberDTO dto) throws Exception;

	// 회원가입
	public void insertMember(MemberDTO dto) throws Exception;

	// 로그인
	public MemberDTO login(MemberDTO dto, HttpSession session) throws Exception;

	// 로그아웃
	public void logout(HttpSession session) throws Exception;

	// 회원탈퇴
	public void deleteMember(MemberDTO dto) throws Exception;

	// 로그인확인 및 정보불러오기
	public MemberDTO loginCheck(MemberDTO dto, HttpSession session) throws Exception;

	// 업데이트 멤버
	public void updateMember(MemberDTO dto);

	// 아이디 찾기
	public String findUserId(MemberDTO dto) throws Exception;

	// 비번 찾기
	public String findUserPassword(Map<String, Object> paramMap) throws Exception;
	
	// 검색 정보 저장
	public void reg_mylog(MylogDTO mldto);

	// 회원 검증
	public int checkPassword(MemberDTO dto) throws Exception;
	
	// 검색 기록 가져오기
	public List<MylogDTO> logList(String id) throws Exception;
	
	// 議고쉶 �꽑�깮
	public MylogDTO selectMylog(MylogDTO dto) throws Exception;
	
	// 검색 기록 삭제
	public void deleteMylog(MylogDTO dto) throws Exception;
}
