package com.daon.host.web.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.daon.host.web.vo.LoginVo;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;

@Component
public class Response {

    @Getter
    @Builder
    private static class Body {
        private int state;
        private String result;
        private String message;
        private Object data;
        private Object error;
    }

    @Getter
    @Builder
    private static class BodyLogin {
		private String resultCd;
		private String resultMsg;
		private String levelCd;
		private String firstRun;
		private String resetPassword;
    }
    
    @Getter
    @Builder
    private static class BodyResult{
		private String resultCd;
		private String resultMsg;
    }
    
    @Getter
    @Builder
    private static class BodyResultError{
		private String resultCd;
		private String resultMsg;
        private Object error;
    }
    @Getter
    @Builder
    private static class BodyList{
		private String resultCd;
		private String resultMsg;
		private Object list;
    }
    
    @Getter
    @Builder
    private static class BodyNoticeDetail{
		private String resultCd;
		private String resultMsg;
		private String title;
		private String contents;
		private String regMan;
		private String regDtm;
    }
    
   //성공-로그인
    public ResponseEntity<?> successLogin(Object data, String msg, HttpStatus status) {
    	
    	LoginVo.LoginResult _data=  (LoginVo.LoginResult)data;
    	BodyLogin body = BodyLogin.builder()
                .resultCd("00")
                .resultMsg(msg)
                .levelCd(_data.getLevelCd())
                .firstRun(_data.getFirstRun())
                .resetPassword(_data.getResetPassword())
                .build();
        return ResponseEntity.ok(body);
    }

    //성공-코드,결과만 반환(비밀번호변경,공지사항 관리, 사용자 ID 중복 확인, 사용자 관리, 단지관리, 권한별 메뉴관리)
    public ResponseEntity<?> successResult(Object data, String msg, HttpStatus status) {
    	BodyResult body = BodyResult.builder()
                .resultCd("00")
                .resultMsg(msg)
                .build();
        return ResponseEntity.ok(body);
    }
    
    //성공-리스트(현장상태조회, 공지사항리스트, 사용자리스트, 단지리스트, 메뉴관리, 권한별 메뉴조회)
    public ResponseEntity<?> successList(Object data, String msg, HttpStatus status) {
    	BodyList body = BodyList.builder()
                .resultCd("00")
                .resultMsg(msg)
                .list(data)
                .build();
        return ResponseEntity.ok(body);
    }
    
    
  //실패-코드,결과만 반환
    public ResponseEntity<?> failResult(String msg, HttpStatus status) {
        return failResult(Collections.emptyList(), msg, status);
    }
    
    //실패-코드,결과만 반환
    public ResponseEntity<?> failResult(Object data, String msg, HttpStatus status) {
    	BodyResult body = BodyResult.builder()
                .resultCd("20")
                .resultMsg(msg)
                .build();
        return ResponseEntity.ok(body);
    }
    
    
    //validation
    public ResponseEntity<?> failInvalidFields(LinkedList<LinkedHashMap<String, String>> errors) {
      
        
    	BodyResultError body = BodyResultError.builder()
                .resultCd("30")
                .resultMsg("입력값이 유효하지 않습니다.")
                .error(errors)
                .build();
        return ResponseEntity.ok(body);
        
    }
    
    //validation
    public ResponseEntity<?> failError(String msg) {
      
        
    	BodyResultError body = BodyResultError.builder()
                .resultCd("40")
                .resultMsg("regType이 유효하지 않습니다.")
                .error(msg)
                .build();
        return ResponseEntity.ok(body);
        
    }
    public ResponseEntity<?> success(Object data, String msg, HttpStatus status) {
        Body body = Body.builder()
                .state(status.value())
                .data(data)
                .result("success")
                .message(msg)
                .error(Collections.emptyList())
                .build();
        return ResponseEntity.ok(body);
    }

    /**
     * <p> 메세지만 가진 성공 응답을 반환한다.</p>
     * <pre>
     *     {
     *         "state" : 200,
     *         "result" : success,
     *         "message" : message,
     *         "data" : [],
     *         "error" : []
     *     }
     * </pre>
     *
     * @param msg 응답 바디 message 필드에 포함될 정보
     * @return 응답 객체
     */
    public ResponseEntity<?> success(String msg) {
        return success(Collections.emptyList(), msg, HttpStatus.OK);
    }
    
    /**
     * <p> 메세지와 성공응답을 반환한다.</p>
     * <pre>
     *     {
     *         "state" : status,
     *         "result" : success,
     *         "message" : message,
     *         "data" : [],
     *         "error" : []
     *     }
     * </pre>
     *
     * @param msg 응답 바디 message 필드에 포함될 정보
     * @return 응답 객체
     */
    public ResponseEntity<?> success(String msg, HttpStatus status) {
    	return success(Collections.emptyList(), msg, status);
    }

    /**
     * <p> 데이터만 가진 성공 응답을 반환한다.</p>
     * <pre>
     *     {
     *         "state" : 200,
     *         "result" : success,
     *         "message" : null,
     *         "data" : [{data1}, {data2}...],
     *         "error" : []
     *     }
     * </pre>
     *
     * @param data 응답 바디 data 필드에 포함될 정보
     * @return 응답 객체
     */
    public ResponseEntity<?> success(Object data) {
        return success(data, null, HttpStatus.OK);
    }

    /**
     * <p> 성공 응답만 반환한다. </p>
     * <pre>
     *     {
     *         "state" : 200,
     *         "result" : success,
     *         "message" : null,
     *         "data" : [],
     *         "error" : []
     *     }
     * </pre>
     *
     * @return 응답 객체
     */
    public ResponseEntity<?> success() {
        return success(Collections.emptyList(), null, HttpStatus.OK);
    }

    public ResponseEntity<?> fail(Object data, String msg, HttpStatus status) {
        Body body = Body.builder()
                .state(status.value())
                .data(data)
                .result("fail")
                .message(msg)
                .error(Collections.emptyList())
                .build();
        return ResponseEntity.ok(body);
    }

    /**
     * <p> 메세지를 가진 실패 응답을 반환한다. </p>
     * <pre>
     *     {
     *         "state" : HttpStatus Code,
     *         "result" : fail,
     *         "message" : message,
     *         "data" : [],
     *         "error" : [{error1}, {error2}...]
     *     }
     * </pre>
     *
     * @param msg 응답 바디 message 필드에 포함될 정보
     * @param status 응답 바디 status 필드에 포함될 응답 상태 코드
     * @return 응답 객체
     */
    public ResponseEntity<?> fail(String msg, HttpStatus status) {
        return fail(Collections.emptyList(), msg, status);
    }

    public ResponseEntity<?> invalidFields(LinkedList<LinkedHashMap<String, String>> errors) {
        Body body = Body.builder()
                .state(HttpStatus.BAD_REQUEST.value())
                .data(Collections.emptyList())
                .result("fail")
                .message("")
                .error(errors)
                .build();
        return ResponseEntity.ok(body);
    }
}