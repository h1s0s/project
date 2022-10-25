package javaex.service;

import java.util.List;

import javaex.dao.MyDogDao;
import javaex.vo.GalleryVo;
import javaex.vo.MyDogVo;
import javaex.vo.PhotoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyDogService {

	@Autowired
    MyDogDao myDogDao;
	
	//insert
	public void myDogInsert(MyDogVo mvo) {
		
		myDogDao.myDogInsert(mvo);
	}
	
	public MyDogVo myDogSelect(int usersNo) {
		
		return myDogDao.myDogSelect(usersNo);
	}
	
	//갤러리 insert
	public void galleryInsert(GalleryVo gvo) {
		
		myDogDao.galleryInsert(gvo);
	}
	
	//갤러리 select
	public List<GalleryVo> gallerySelect(int usersNo) {
		
		return myDogDao.gallerySelect(usersNo);
	}
	
	//포토 update
	public void myDogPhotoUpdate(PhotoVo pvo) {
		
		//포토이름불러오기
		int pNum = pvo.getPhotoNo();
		PhotoVo newPvo = myDogDao.photoSelect(pNum);
		newPvo.setUsersNo(pvo.getUsersNo());
		System.out.println(newPvo);
		
		myDogDao.myDogPhotoUpdate(newPvo);
	}
}
