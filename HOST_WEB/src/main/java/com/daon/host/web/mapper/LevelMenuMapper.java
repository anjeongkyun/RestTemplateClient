package com.daon.host.web.mapper;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.daon.host.web.vo.LevelMenuVo;
import com.daon.host.web.vo.LevelMenuVo.CRUD;
import com.daon.host.web.vo.LoginVo;

@Component
@Mapper
public interface LevelMenuMapper {

	List<CRUD> getList(@Param("req") LevelMenuVo.CRUD levelMenu);
	int insertLevel(@Param("req") LevelMenuVo.CRUD user);
	int updateLevel(@Param("req")  LevelMenuVo.CRUD user);
	int deleteLevel(@Param("req") LevelMenuVo.CRUD user);
	

}