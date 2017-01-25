package com.example.domain;

import org.springframework.data.repository.CrudRepository;

public interface WriterRepository extends CrudRepository<Question, Long>{ // 어떤 Entitry/ User클래스에 아이디로 설정한 데이터타입

}

