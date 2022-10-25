package javaex.service;

import javaex.dao.ReviewDao;
import javaex.vo.ReviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	public void review(ReviewVo reviewVo) {
		System.out.println("여기는 서비스");
		
		int result = reviewDao.updateReview(reviewVo);
		
		System.out.println(result);
		
		if(result != 0) {
			reviewDao.updateStatus3(reviewVo.getBookingNo());
		}
	}
	
}
