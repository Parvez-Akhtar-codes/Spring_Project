package org.studyeasy.SpringBlog.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.studyeasy.SpringBlog.models.Account;
import org.studyeasy.SpringBlog.models.Authority;
import org.studyeasy.SpringBlog.models.Post;
import org.studyeasy.SpringBlog.services.AccountService;
import org.studyeasy.SpringBlog.services.AuthorityService;
import org.studyeasy.SpringBlog.services.PostService;
import org.studyeasy.SpringBlog.util.constants.Previllage;
import org.studyeasy.SpringBlog.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner{

   
    @Autowired
    private  PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

   

    @Override
    public void run(String... args) throws Exception {

       for(Previllage auth : Previllage.values()){
        Authority authority = new Authority();
        authority.setId(auth.getId());
        authority.setName(auth.getprevillage());
        authorityService.save(authority);
       }

       Account account01 = new Account();
       Account account02 = new Account();
       Account account03 = new Account();
       Account account04 = new Account();

       account01.setEmail("user@user.org");
       account01.setPassword("password");
       account01.setFirstname("user");
       account01.setLastname("user1");


       account02.setEmail("admin@admin.org");
       account02.setPassword("password");
       account02.setFirstname("admin");
       account02.setLastname("admin1");
       account02.setRole(Roles.ADMIN.getRole());

       account03.setEmail("editor@editor.org");
       account03.setPassword("password");
       account03.setFirstname("editor");
       account03.setLastname("editor1");
       account03.setRole(Roles.EDITOR.getRole());

       account04.setEmail("super_editor@editor.org");
       account04.setPassword("password");
       account04.setFirstname("super_editor");
       account04.setLastname("editor2");
       account04.setRole(Roles.EDITOR.getRole());
       Set<Authority> Authorities = new HashSet<>();
       authorityService.findById(Previllage.RESET_ANY_USER_PASSWORD.getId()).ifPresent(Authorities::add);
       authorityService.findById(Previllage.ACCESS_ADMIN_PANEL.getId()).ifPresent(Authorities::add);
       account04.setAuthorities(Authorities);


       accountService.save(account01);
       accountService.save(account02);
       accountService.save(account03);
       accountService.save(account04);
       


       List<Post> posts = postService.getAll();
       if (posts.size() == 0){
            Post post01 = new Post();
            post01.setTitle("Post 01");
            post01.setBody("Post 01 body.....................");
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Post 02");
            post02.setBody("Post 02 body.....................");
            post02.setAccount(account02);
            postService.save(post02);

       }
        
    }
    
}
