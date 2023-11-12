package com.example.quiz.dao.interfaces;

import com.example.quiz.domain.Contact;

import java.util.List;

/**
 * @author Tianhao Yang
 * @create 2023 11 11 10:14 PM
 */
public interface MessageDao {
    /**
     * Saves a message to the database.
     *
     * @param mess The Contact object representing the message to be saved.
     */
    void saveMessage(Contact mess);

    /**
     * Retrieves all contacts from the database.
     *
     * @return A List of Contact objects.
     */
    List<Contact> findAllContacts();
}
