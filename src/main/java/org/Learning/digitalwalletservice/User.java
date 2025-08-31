package org.Learning.digitalwalletservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String name;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final String id ;
    private final List<Account> accounts;

    public User(String name, String email, String password, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accounts= new ArrayList<>();
    }

    public void addAcount(Account account){
        accounts.add(account);
    }

    public void removeAccount(Account account){
        accounts.remove(account);
    }

    public String getId(){
        return  id ;
    }
}
