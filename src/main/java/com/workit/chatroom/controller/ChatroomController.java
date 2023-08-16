package com.workit.chatroom.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.workit.chat.service.ChatService;
import com.workit.chatroom.model.dto.AttachedFile;
import com.workit.chatroom.service.ChatroomService;
import com.workit.member.model.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/chatroom")
public class ChatroomController {
	
	private ChatroomService chatroomService;
	private ChatService chatService;
	
	public ChatroomController(ChatroomService chatroomService, ChatService chatService) {
		this.chatroomService = chatroomService;
		this.chatService = chatService;
	}
	
	@PostMapping("/upload")
    public ResponseEntity<String>  uploadFile(@RequestParam("files") List<MultipartFile> files, @RequestParam(value="chatroomId") String chatroomId) throws IOException {
		log.info("{}", chatroomId);
		log.info("{}", files);
		List<AttachedFile> list = new ArrayList<AttachedFile>();
		if(files!=null && files.size()>0) {
			try {
					for (MultipartFile multipartFile : files) {
						log.info("{}", multipartFile.getOriginalFilename());
						AttachedFile uploadFile = chatroomService.saveFile(multipartFile, chatroomId);
						log.info("controller file");
						log.info("{}", uploadFile);
						if(uploadFile!=null) {
							list.add(uploadFile);
							// 클라이언트로 업로드 결과 전달
							return ResponseEntity.ok("Files uploaded successfully.");
						}else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed.");
					}
				
			}catch(IOException e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed.");
			}
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed.");
    }
	
	@GetMapping("/download/{uploadFile:.+}")
	@ResponseBody
    public ResponseEntity<Resource>  downloadFile(@PathVariable String uploadFile, HttpSession session) throws IOException {
        // 파일을 저장한 디렉토리 경로 설정
        String fileDirectory = session.getServletContext().getRealPath("/resources/upload/chat/");
        log.info("fileDirectory : " + fileDirectory);
        Path filePath = Paths.get(fileDirectory, uploadFile);
        log.info("filePath : " + filePath);
        Resource resource = new ByteArrayResource(Files.readAllBytes(filePath));
        String fileUrl = fileDirectory + uploadFile;
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", uploadFile);
        
        return ResponseEntity.ok()
              .headers(headers)
              .body(resource);
    }
	
	@PostMapping("/file")
	public ResponseEntity<?> selectFileByRoomId(@RequestParam("chatroomId")String chatroomId){
		log.info("{}", chatroomId);
		return ResponseEntity.ok().body(chatroomService.selectFileByChatroomId(chatroomId));
	}
	
	@PostMapping("/update")
	@ResponseBody
	public int updateChatroomMember(@RequestParam(value="chatMember")String chatMember, @RequestParam(value="chatroomId") String chatroomId, HttpSession session, Model model) {
		return chatService.updateChatroomMember(Map.of("member",chatMember,"chatroomId",chatroomId));
	}
	
	@PostMapping("/search")
	@ResponseBody
	public ResponseEntity<?> searchChatroomByKeyword(@RequestParam(value="chatroomId")String chatroomId, @RequestParam(value="keyword")String keyword) {
		log.info(keyword);
		log.info(chatroomId);
		log.info("{}", chatService.searchByKeyword(Map.of("chatroomId",chatroomId, "keyword",keyword)));
		return ResponseEntity.ok().body(chatService.searchByKeyword(Map.of("chatroomId",chatroomId, "keyword",keyword)));
	}
	
	@PostMapping("/unread")
	public void chatNotificationCount(HttpSession session, Model model) {
		MemberVO member = (MemberVO)session.getAttribute("loginMember");
		String loginMember = member.getMemberId();
		int unread = chatroomService.chatNotificationCount(loginMember);
		model.addAttribute("unread", unread);
	}
	
	@PostMapping("/profile")
	@ResponseBody
	public ResponseEntity<?> selectMemberByChoice (@RequestParam(value="memberId") String memberId){
		log.info("memberId : " + memberId);
		return ResponseEntity.ok(chatroomService.selectMemberByChoice(memberId));
	}
	
	
	
}
