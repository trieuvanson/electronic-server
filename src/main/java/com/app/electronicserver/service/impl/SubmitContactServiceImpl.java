package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.SubmitContact;
import com.app.electronicserver.repo.SubmitContactRepo;
import com.app.electronicserver.service.SubmitContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service @RequiredArgsConstructor
@Transactional
@Slf4j
public class SubmitContactServiceImpl implements SubmitContactService {

    private final SubmitContactRepo submitContactRepo;

    @Override
    public List<SubmitContact> getSubmitContact() {
        return submitContactRepo.findAll();
    }

    @Override
    public SubmitContact saveSubmitContact(SubmitContact submitContact) {
        return submitContactRepo.save(submitContact);
    }

    @Override
    public SubmitContact updateSubmitContact(SubmitContact submitContact, Long id) {
        submitContact.setId(id);
        submitContact.setUpdate_at(new Date());
        return submitContactRepo.save(submitContact);
    }

    @Override
    public void deleteSubmitContact(Long id) {
        SubmitContact submitContact = findById(id);
        submitContactRepo.delete(submitContact);
    }

    @Override
    public SubmitContact findById(Long id) {
        return submitContactRepo.findById(id).get();
    }
}
