package com.daon.host.web.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자
public class ParkVo {
	
	private String aptId;
	private String projectId;
	private String aptNm;
	private String aptAddress;
	private String repNum;
	private String managerNm;
	private String latitude;
	private String longitude;
	private String insId;
	private Date insDate;
	private String updId;
	private Date updDate;
}