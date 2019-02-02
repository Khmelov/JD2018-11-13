package by.it.vchernetski.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdList implements Cmd{
   @Override
   public Action execute(HttpServletRequest request)throws Exception {
       return Action.INDEX;
   }
}
