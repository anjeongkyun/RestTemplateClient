package com.daon.host.web.vo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class NoticeVo {

	@ApiModelProperty(example="공지번호")
	private String noticeNo; // 공지번호
	private String aptId; // 단지코드
	private String noticeWriter; // 공지작성자
	private String noticeContent; // 공지내용
	private String noticeTitle; // 공지제목
	private String remark; // 비고
	private String insId; // 입력자

	private Date insDate; // 입력시간
	
	private String updId; // 수정자
	private Date updDate; // 수정시간
}