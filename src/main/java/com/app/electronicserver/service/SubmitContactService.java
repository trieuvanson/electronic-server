package com.app.electronicserver.service;

import com.app.electronicserver.model.SubmitContact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubmitContactService {
    List<SubmitContact> getSubmitContact();

    SubmitContact saveSubmitContact(SubmitContact submitContact);

    SubmitContact updateSubmitContact(SubmitContact submitContact, Long id);

    void deleteSubmitContact(Long id);

    SubmitContact findById(Long id);
}
