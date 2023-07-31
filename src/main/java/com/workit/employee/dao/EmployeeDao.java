package com.workit.employee.dao;

import java.util.List;
import java.util.Map;

import com.workit.employee.model.vo.DepartmentVO;
import com.workit.employee.model.vo.JobVO;
import com.workit.member.model.dto.Department;
import com.workit.member.model.dto.Job;
import com.workit.member.model.dto.Member;

public interface EmployeeDao {
	
	List<Department> selectDept();
	
	List<Job> selectJob();
	
	int insertEmployee(Map<String,Object> param);
	
	List<Member> selectMemberAll(Map<String, Object> param);

	int selectMemberCount();
	
	List<DepartmentVO> selectDeptCount(Map<String, Object> param);
	
	List<JobVO> selectJobCount(Map<String, Object> param);
	
	int selectGradeCount(Map<String,Object> param);

	int insertDept(String deptName);

	int deleteDept(String deptCode);
	
	int updateDept(Map<String,Object> param);
}
