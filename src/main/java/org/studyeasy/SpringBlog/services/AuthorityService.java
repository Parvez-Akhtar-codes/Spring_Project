package org.studyeasy.SpringBlog.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studyeasy.SpringBlog.models.Authority;
import org.studyeasy.SpringBlog.repositories.AuthorityRepository;

@Service
public class AuthorityService {

    @Autowired
    private  AuthorityRepository authorityRepository ;
    
    public Optional<Authority> findById(Long id){
        return authorityRepository.findById(id);
    }


    public Authority save(Authority authority){
        return authorityRepository.save(authority);
    }
    
    
    
}
