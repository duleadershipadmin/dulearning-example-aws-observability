package com.dulearning.observability.aws.api;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface MessageRepository extends CrudRepository<Message, String> {
    Optional<Message> findMessageById(String id);
    List<Message> findMessagesByUsername(String username);
}
