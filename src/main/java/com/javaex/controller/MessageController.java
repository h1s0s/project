package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.MessageService;
import com.javaex.vo.MessageVo;

@Controller
public class MessageController {
   
   @Autowired
   MessageService messageService;
   
   //map으로 리스트와 정보 가져오기 +유저타입 받아오기(호스트인지 아닌지)
   @RequestMapping(value="/message", method = {RequestMethod.GET, RequestMethod.POST})
   public String message( @RequestParam int usersNo,
                        Model model,
                        HttpSession session) {
      //유저 타입
      MessageVo getType = messageService.getType(usersNo);
      model.addAttribute("getType", getType);
      System.out.println(getType);
      
      List<MessageVo> getList = messageService.getList(usersNo);
      model.addAttribute("getList", getList);
      return "kang/message";
      
   }
   
   //메세지 가져오기
   @RequestMapping(value="/message/getm", method = {RequestMethod.GET, RequestMethod.POST})
   public String getM( @ModelAttribute MessageVo messageVo,
                     @RequestParam int usersNo,
                     @RequestParam int roomNo,
                     @RequestParam int target,
                        Model model,
                        HttpSession session){
      List<MessageVo> mList = messageService.getMessage(target);
      model.addAttribute("mList", mList);
      System.out.println(mList +"mList컨트롤러");
      
      return "kang/message";
   }
   
   
   //메세지 보내기
   @RequestMapping(value="/message/setm", method = {RequestMethod.GET, RequestMethod.POST})
   public String setM( @ModelAttribute MessageVo messageVo,
                     @RequestParam int usersNo,
                        HttpSession session) {
      System.out.println(messageVo);
      messageService.sentM(messageVo);
      System.out.println("인서트 컨트롤러");
      
      
      return "redirect://message/getm?roomNo=${roomNo}&target=${target}&usersNo="+ usersNo;
   }
   
   //맨처음 대화 시작하기
//   @RequestMapping(value="/message/setm", method = {RequestMethod.GET, RequestMethod.POST})
//   public String startM( @ModelAttribute MessageVo messageVo,
//                     @RequestParam int usersNo,
//                        Model model,
//                        HttpSession session) {
//      
//      
//   }
   
   
   //메세지 읽기
//   @RequestMapping(value="/message/read", method = {RequestMethod.GET, RequestMethod.POST})
//   public String read( @RequestParam int usersTo,
//                        Model model) {
//      
//      MessageVo rVo = messageService.getUser(usersTo);
//      
//      model.addAttribute("messageVo", rVo);
//      System.out.println(rVo+"컨트롤러");
//      
//      
//      return "kang/message";
//      
//   }
   
   //한번 해보는겨
//   public int once(int usersFrom) {
//      
//      MessageVo nVo = messageService.getN(usersFrom); 
//      System.out.println(nVo+"nVo컨트롤러");
//      
//      return usersFrom;
//      
//   }
   
   
}