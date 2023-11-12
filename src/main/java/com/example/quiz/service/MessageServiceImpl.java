package com.example.quiz.service;

import com.example.quiz.dao.MessageDaoImpl;
import com.example.quiz.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tianhaoyang on 11/6/23.
 */

@Service
public class MessageServiceImpl{

    @Autowired
    private MessageDaoImpl messageDao;

    public void saveContactMessage(Contact message) {
        messageDao.saveMessage(message);
    }

    public List<Contact> getAllContacts() {
        return messageDao.findAllContacts();
    }

}


