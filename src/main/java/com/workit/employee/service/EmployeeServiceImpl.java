package com.workit.employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workit.employee.dao.EmployeeDao;
import com.workit.employee.model.vo.DepartmentVO;
import com.workit.employee.model.vo.JobVO;
import com.workit.member.model.dto.Department;
import com.workit.member.model.dto.Job;
import com.workit.member.model.dto.Member;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;
	
	@Override
	public List<Department> selectDept() {
		return dao.selectDept();
	}

	@Override
	public List<Job> selectJob() {
		return dao.selectJob();
	}

	@Override
	public int insertEmployee(Map<String, Object> param) {
		String address=((String)param.get("main-address"))+" "+(String)param.get("datail-address");
		param.put("address", address);
		return dao.insertEmployee(param);
	}

	@Override
	public List<Member> selectMemberAll(Map<String, Object> param) {
		return dao.selectMemberAll(param);
	}

	@Override
	public int selectMemberCount() {
		return dao.selectMemberCount();
	}

	@Override
	public List<DepartmentVO> selectDeptCount(Map<String, Object> param) {
		return dao.selectDeptCount(param);
	}

	@Override
	public List<JobVO> selectJobCount(Map<String, Object> param) {
		return dao.selectJobCount(param);
	}

	@Override
	public int selectGradeCount(Map<String, Object> param) {
		return dao.selectGradeCount(param);
	}

	@Override
	public int insertDept(String deptName) {
		return dao.insertDept(deptName);
	}

	@Override
	public int deleteDept(String deptCode) {
		return dao.deleteDept(deptCode);
	}

	@Override
	public int updateDept(Map<String,Object> param) {
		return dao.updateDept(param);
	}

	@Override
	public int updateEmpInfo(Map<String, Object> param) {
		return dao.updateEmpInfo(param);
	}

}