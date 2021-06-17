package com.kedu.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private HttpSession session;

    public int joinUser(UserEntity param){
        System.out.println(param);
        String crpytPw = BCrypt.hashpw(param.getUpw(),BCrypt.gensalt());
        param.setUpw(crpytPw);
        return mapper.insUser(param);
    }
    public String loginUser(UserEntity param){
      UserEntity result =  mapper.selUser(param);
      if(result == null){
          //아이디X
          return "/user/login?err=1";
      } else if(BCrypt.checkpw(param.getUpw(),result.getUpw())) {
          //아이디 O 비번O
          result.setUpw(null);
          session.setAttribute("loginUser",result);
          return "/board/list";
      } else{
          //비번X
          return "/user/login?err=2";
      }


    }

}
