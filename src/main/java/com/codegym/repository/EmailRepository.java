package com.codegym.repository;


import com.codegym.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository{

    private static final List<Email> emailist;

    static {
        emailist = new ArrayList<>();

        emailist.add(new Email(1, "EngList", 5, false, "OK"));
        emailist.add(new Email(2, "EngList", 5, false, "OK"));
        emailist.add(new Email(3, "EngList", 5, false, "OK"));
        emailist.add(new Email(4, "EngList", 5, false, "OK"));
        emailist.add(new Email(5, "EngList", 5, false, "OK"));
        emailist.add(new Email(6, "EngList", 5, false, "OK"));

    }
    @Override
    public List<Email> displayAll() {
        return emailist;
    }

    @Override
    public Email findById(int id) {
        return emailist.get(id);
    }

    @Override
    public Email edit(Email email) {
        Email origin = findById(email.getId());
        origin.setLanguages(email.getLanguages());
        origin.setPageSize(email.getPageSize());
        origin.setSignature(email.getSignature());
        origin.setSpamsFilter(email.isSpamsFilter());

        return origin;
    }

    @Override
    public List<String> languageList() {
        List<String> language = new ArrayList<>();
        language.add("EngLish");
        language.add("Vietnamese");
        language.add("Japanese");
        language.add("Chinese");
        return language;
    }

    @Override
    public List<Integer> pageSizeList() {
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(20);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
        return pageSize;
    }
}
