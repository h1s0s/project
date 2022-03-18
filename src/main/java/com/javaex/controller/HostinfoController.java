package com.javaex.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.HostinfoService;
import com.javaex.vo.BookingVo;
import com.javaex.vo.HostVo;
import com.javaex.vo.KeywordVo;
import com.javaex.vo.PhotoVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/host", method = { RequestMethod.GET, RequestMethod.POST })
public class HostinfoController {
	
	@Autowired
	HostinfoService hostinfoService;
	
	//펫시터 신청 폼
	@RequestMapping(value = "/hostjoin", method = { RequestMethod.GET, RequestMethod.POST })
	public String hostJoinForm(Model model) {
		System.out.println("[hostinfoController.hostJoinForm()]");
		
		//키워드리스트
		List<KeywordVo> keywordList = hostinfoService.getKeywordList();
		model.addAttribute("keywordList", keywordList);
		
		return "/host/hostJoinForm";
	}
	
	//host insert, user update
	@ResponseBody
	@RequestMapping(value = "/hostinsert", method = { RequestMethod.GET, RequestMethod.POST })
	public int hostinsert(@ModelAttribute HostVo hostVo, HttpSession session) {
		System.out.println("[hostinfoController.hostinsert()]");
		
		//펫시터 insert
		hostinfoService.hostinsert(hostVo);
		
		//변경된 정보 세션에 담기
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		authUser.setUsersType(2);
		authUser.setHostNo(hostVo.getHostNo());
		session.setAttribute("authUser", authUser);
		int hostNo = hostVo.getHostNo();
		
		return hostNo;	
	}
	
	//펫시터 사진 insert
	@ResponseBody
	@RequestMapping(value = "/hostphotoinsert", method = { RequestMethod.GET, RequestMethod.POST })
	public int hostphotoinsert(@RequestParam("images") List<MultipartFile> files,
							   @RequestParam("hostNo") int hostNo) {
		System.out.println("[hostinfoController.hostphotoinsert()]");

		//펫시터사진 insert하기
		for(MultipartFile file: files) {
			hostinfoService.fileupload(file, hostNo);
		}
		
		return hostNo;
	}	
	
	//펫시터 키워드 insert
	@ResponseBody
	@RequestMapping(value = "/hostkeywordinsert", method = { RequestMethod.GET, RequestMethod.POST })
	public int hostkeywordinsert(@RequestParam("keywordNo[]") List<Integer> keyList,
								 @RequestParam("hostNo") int hostNo) {
		System.out.println("[hostinfoController.hostkeywordinsert()]");
		
		//펫시터 키워드 insert
		hostinfoService.setKeyword(keyList, hostNo);
		
		return hostNo;
	}
	
	//펫시터 정보 폼
	@RequestMapping(value = "/info/{hostNo}", method = { RequestMethod.GET, RequestMethod.POST })
	public String hostinfoForm(@PathVariable("hostNo") int hostNo, Model model,
							   @RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {
		System.out.println("[hostinfoController.hostinfoForm()]");

		int authNo = hostinfoService.checkNo(hostNo);
		
		if(authNo > 0) {
			Map<String, Object> hostMap = hostinfoService.getHostMap(hostNo, crtPage);
			model.addAttribute("hostMap", hostMap);
			
			return "/host/hostinfo";
			
		} else {//펫시터가 없음
			System.out.println("[실패: 존재하지 않는 펫시터 입니다.]");
			return "/host/booking";
		}
	}
	//사진 탭 클릭시
	@ResponseBody
	@RequestMapping(value = "/getPhoto", method = { RequestMethod.GET, RequestMethod.POST })
	public List<PhotoVo> getPhoto(@ModelAttribute PhotoVo photoVo, Model model) {
		System.out.println("[hostinfoController.getPhoto()]");
		
		if("호스트사진".equals(photoVo.getCategory())) {
			return hostinfoService.getHostPhoto(photoVo.getHostNo());
		} else {
			return hostinfoService.getPhoto(photoVo);
		}
	}
	
	//펫시팅 예약 폼
	@RequestMapping(value = "/booking", method = { RequestMethod.GET, RequestMethod.POST })
	public String bookinginsertForm(@RequestParam("hostNo") int hostNo, Model model) {
		System.out.println("[hostinfoController.bookinginsertForm()]");
		
		HostVo hostVo = hostinfoService.getHost(hostNo);
		model.addAttribute("hostVo", hostVo);
		
		return "/host/booking";
	}
	//able
	@ResponseBody
	@RequestMapping(value = "/getAble", method = { RequestMethod.GET, RequestMethod.POST })
	public List<String> getAble(@RequestParam("hostNo") int hostNo, Model model) {
		System.out.println("[hostinfoController.getAble()]");
		
		List<String> ableList = hostinfoService.getBooking(hostNo);
		
		return ableList;
	}
	
	//예약
	@ResponseBody
	@RequestMapping(value = "/bookinginsert", method = { RequestMethod.GET, RequestMethod.POST })
	public int bookinginsert(@ModelAttribute BookingVo bookingVo) {
		System.out.println("[hostinfoController.bookinginsert()]");
		
		hostinfoService.checkdays(bookingVo);//일수 계산
		int count = hostinfoService.bookinginsert(bookingVo);
		
		return count;
	}
	
	//호스트 정보 수정폼
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam("hostNo") int hostNo) {
		System.out.println("[hostinfoController.modifyForm()]");
		
		return "/host/modifyForm";
	}
}