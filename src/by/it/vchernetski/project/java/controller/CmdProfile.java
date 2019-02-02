package by.it.vchernetski.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdProfile implements Cmd{
   @Override
   public Action execute(HttpServletRequest request)throws Exception {
       if(!Util.checkUser(request)){
           return Action.LOGIN;
       }
       return Action.PROFILE;
   }
}
