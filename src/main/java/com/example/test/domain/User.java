package com.example.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // getter, setter, toString만들어줌
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 생성자
@Entity
@Table(name ="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 50, unique = true)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	private String email;
	
	
}
