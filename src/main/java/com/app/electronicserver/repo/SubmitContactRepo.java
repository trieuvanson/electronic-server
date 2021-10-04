package com.app.electronicserver.repo;

import com.app.electronicserver.model.SubmitContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmitContactRepo extends JpaRepository<SubmitContact, Long> {
}
