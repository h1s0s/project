package javaex.dao;

import java.util.List;

import javaex.vo.GalleryVo;
import javaex.vo.MyDogVo;
import javaex.vo.PhotoVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyDogDao {
	
	@Autowired
	SqlSession sqlSession;
	
	//insert
	public void myDogInsert(MyDogVo mvo) {
		
		sqlSession.insert("mydog.insert", mvo);
	}
	
	public MyDogVo myDogSelect(int usersNo) {
		
		return sqlSession.selectOne("mydog.select", usersNo);
	}
	
	//갤러리 insert
	public void galleryInsert(GalleryVo gvo) {
		
		sqlSession.insert("mydog.glleryInsert", gvo);
	}
	
	//갤러리 select
	public List<GalleryVo> gallerySelect(int usersNo) {
		
		return sqlSession.selectList("mydog.gllerySelect", usersNo);
	}
	
	//포토테이블 select
	public PhotoVo photoSelect(int photoNo) {
		
		return sqlSession.selectOne("mydog.photoSelect", photoNo);
	}
	
	//mydog포토 update
	public void myDogPhotoUpdate(PhotoVo pvo) {
		
		sqlSession.update("mydog.glleryUpdate", pvo);
	}

}
