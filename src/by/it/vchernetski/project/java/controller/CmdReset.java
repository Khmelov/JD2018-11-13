package by.it.vchernetski.project.java.controller;


import by.it.vchernetski.project.java.dao.Connect;

import javax.servlet.http.HttpServletRequest;

class CmdReset implements Cmd{
   @Override
   public Action execute(HttpServletRequest request)throws Exception {
       Connect.resetSCHEMA();
       return Action.INDEX;
   }
}
