package com.koreait.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.utils.MyFileUtils;
import com.koreait.utils.MyUtils;
import com.koreait.vo.UserEntity;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/user/mypage")
public class UserMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserEntity loginUser = MyUtils.getLoginUser(request);

		request.setAttribute("user", UserDAO.selUser(loginUser));

		MyUtils.openJSP("머아페이지", "user/userMypage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String uploadPath = request.getRealPath("/res/img");
		String uploadPath = request.getServletContext().getRealPath("/res/img");
		// 현제 톰캣이 돌아가는 절대위치+"/res/img" 리턴

		int maxFileSize = 10_485_760;// 10*1024*1024(10mb)
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize, "utf-8",
					new DefaultFileRenamePolicy());

			String fileNm = multi.getFilesystemName("profileImg");
			
			System.out.println("fileNm : " + fileNm);
			if(fileNm == null) {
				doGet(request, response);
				//forwad 오류 doget 2번실행ㄹ
				
				return;
			}
			
			// 유저 정보
			UserEntity loginUser = MyUtils.getLoginUser(request);
			int loginUserPk = MyUtils.LoginUserPK(request);

			String targetFolder = uploadPath + "/user/" + loginUserPk;
			MyFileUtils.delFolder(targetFolder);

			File folder = new File(targetFolder);
			// folder.delete(); 폴더 안에 파일이 있으면 안지워짐.
			folder.mkdirs();// m(ake)dir(ect)


			int lastDotIdx = fileNm.lastIndexOf("."); // lastIndexOf 오른쪽으로 부터 계산 idx은 왼쪽부터 0~
			String ext = fileNm.substring(lastDotIdx);
			// substring(idx) idx이후로 짤라서 리턴 리턴값 = .확장자명

			String newFileNm = UUID.randomUUID().toString() + ext;

			File imgFile = new File(uploadPath + "/temp/" + fileNm); // 방급 업로드된 파일의 주속값
			imgFile.renameTo(new File(targetFolder + "/" + newFileNm));
			// renameTo(new File(이동경로 + 바꿀 파밍명)); -> 이동하고 바꿈 즉 그 대상의 가지는 속성이 된다.

			UserEntity param = new UserEntity();
			param.setIuser(loginUserPk);
			param.setProfileImg(newFileNm);

			UserDAO.updUser(param);

			loginUser.setProfileImg(newFileNm);
		} catch (Exception e) {
			e.getStackTrace();
		}

		doGet(request, response);
	}

}
