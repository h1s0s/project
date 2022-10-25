package javaex.service;

import javaex.dao.FinishPDao;
import javaex.vo.FinishPVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinishPService {
	
	@Autowired
	private FinishPDao finishPDao;
	
	public FinishPVo getBills (int bookingNo) {
		System.out.println("여기는 서비스");
		
		FinishPVo finishPVo = finishPDao.selectP(bookingNo);
		
		System.out.println(finishPVo+"서비스");
		return finishPVo;
	}
	
	//확인버튼 누름
	public void updateStatusP(int bookingNo) {
		
		finishPDao.updateStatusP(bookingNo);
	}

	
	
	
}
