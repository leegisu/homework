package com.example.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{ // 어떤 Entitry/ User클래스에 아이디로 설정한 데이터타입

	User findByuserId(String userId); //DB에서 userId를 기반으로 데이터를 조회해오겠다.
	
}
