package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StuRepository extends JpaRepository<Student, Long> {

	//根据学生姓名查询数据
	Student getStudentBySname(String sname);
	
}
