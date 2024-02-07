package com.ubbcluj.software_system_server.jpa.repository;

import com.ubbcluj.software_system_server.jpa.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message, Long> {
}
