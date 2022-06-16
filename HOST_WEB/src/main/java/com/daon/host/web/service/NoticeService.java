package com.daon.host.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.daon.host.web.dto.Response;
import com.daon.host.web.entity.Notice;
import com.daon.host.web.mapper.NoticeMapper;
import com.daon.host.web.repository.NoticeRepository;
import com.daon.host.web.vo.NoticeVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoticeService {

	private final Response response;
	private final NoticeMapper noticeMapper;
	private final NoticeRepository noticeRepository;
	
	//전체 리스트 조회 
	public ResponseEntity<?> getList() {    			
		//jpa방식
    	List<Notice> notice = noticeRepository.findAll();
    	
    	if(ObjectUtils.isEmpty(notice)) {
    		return response.fail("조회된 정보가 없습니다. 확인하신 후 입력해주세요.", HttpStatus.BAD_REQUEST);
    	}
    	
		return response.success(notice, "조회 성공했습니다.", HttpStatus.OK);
	}
	
	//상세 조회
	public ResponseEntity<?> getDetail(String noticeNo) {
    	if(ObjectUtils.isEmpty(noticeNo) ) {
    		return response.fail("조회 파라미터가 없습니다.", HttpStatus.BAD_REQUEST);
    	}
		
        Optional<Notice> notice = noticeRepository.findByNoticeNo(noticeNo);
        
        if(!notice.isPresent()){
        	return response.fail("조회된 정보가 없습니다. 확인하신 후 입력해주세요.", HttpStatus.BAD_REQUEST);
        }
        
		return response.success(notice, "조회 성공했습니다.", HttpStatus.OK);
	}
	
	//공지사항 작성
	public ResponseEntity<?> insert(NoticeVo notice) {
    	if(ObjectUtils.isEmpty(notice) ) {
    		return response.fail("조회 파라미터가 없습니다.", HttpStatus.BAD_REQUEST);
    	}
		
    	noticeMapper.insert(notice);
    	
		return response.success("공지사항 작성 OK");
	}
	
	//공지사항 삭제
	public ResponseEntity<?> delete(String noticeNo) {
    	if(ObjectUtils.isEmpty(noticeNo)) {
    		return response.fail("조회 파라미터가 없습니다.", HttpStatus.BAD_REQUEST);
    	}
		
    	noticeRepository.deleteByNoticeNo(noticeNo);
    	
		return response.success("공지사항 삭제 OK");
	}

	//공지사항 수정
	public ResponseEntity<?> update(NoticeVo notice) {
    	if(ObjectUtils.isEmpty(notice) ) {
    		return response.fail("조회 파라미터가 없습니다.", HttpStatus.BAD_REQUEST);
    	}
		
    	noticeMapper.update(notice);
    	
		return response.success("공지사항 수정 OK");
	}
	
}
