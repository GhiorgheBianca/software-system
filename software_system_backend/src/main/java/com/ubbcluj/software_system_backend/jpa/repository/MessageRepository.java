package com.ubbcluj.software_system_backend.jpa.repository;

import com.ubbcluj.software_system_backend.jpa.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message, Long> {
}
