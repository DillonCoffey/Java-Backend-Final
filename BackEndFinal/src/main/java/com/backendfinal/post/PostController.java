package com.backendfinal.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendfinal.post.Post;
import com.backendfinal.post.PostRepository;
import com.backendfinal.users.Users;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	PostRepository dao;

	@GetMapping("/post")
	public List<Post> getPost() {
		List<Post> foundMessages = dao.findAll();
		return foundMessages;
	}

	@GetMapping("/post/{id}")
	public ResponseEntity<Post> getUser(@PathVariable(value = "id") Integer id) {
		Post foundMessage = dao.findById(id).orElse(null);

		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundMessage);
	}

	@PostMapping("/post/{id}")
	public ResponseEntity<Post> postMessage(@RequestBody Post message) {

		// saving to DB using instance of the repo interface
		Post createdMessage = dao.save(message);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdMessage);
	}

	@PutMapping("/post/{id}")
	public ResponseEntity<Post> putMessage(@PathVariable Integer id, @RequestBody Post message) {
		Post foundMessage = dao.findById(id).orElse(null);
		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
			if (Users.getUsername() != null) {
				Users.setUsername(Users.getUsername());
			}
			if (Users.getPassword() != null) {
				Users.setPassword(Users.getPassword());
			}
			dao.save(foundMessage);
		}
		return ResponseEntity.ok(foundMessage);
	}

	@DeleteMapping("/post/{id}")
	public ResponseEntity<Post> deleteMessage(@PathVariable(value = "id") Integer id) {
		Post foundMessage = dao.findById(id).orElse(null);

		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
			dao.delete(foundMessage);
		}
		return ResponseEntity.ok().build();
	}
}
