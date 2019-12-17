package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.entity.JhCgd;
import com.sc.entity.JhCgdExample;
import com.sc.mapper.JhCgdMapper;
import com.sc.service.JhCgdService;
@Service
public class JhCgdServiceImpl implements JhCgdService {

	@Autowired
	JhCgdMapper jhCgdMapper;
	
	@Override
	public PageInfo<JhCgd> selectpage(Integer pageNum, Integer pageSize, JhCgd jc) {
		//设置分页数据，开始分页
		PageHelper.startPage(pageNum, pageSize);
		JhCgdExample ex=new JhCgdExample();
		com.sc.entity.JhCgdExample.Criteria criteria = ex.createCriteria();
		//查询当前页的集合数据	
        if(jc.getCgTheme()!=null){
			criteria.andCgThemeLike("%"+jc.getCgTheme()+"%");
				
		}
			List<JhCgd> list = this.jhCgdMapper.selectByExample(ex);
			PageInfo<JhCgd>page=new PageInfo<JhCgd>(list);
		return page;

	}

	@Override
	public JhCgd get(Long cgdId) {
		if(cgdId!=null){
			   return this.jhCgdMapper.selectByPrimaryKey(cgdId);
			}
			return null;
	}

	

	

	@Override
	public void add(JhCgd jc) {
		if(jc!=null){
			this.jhCgdMapper.insert(jc);
		}

	}

}