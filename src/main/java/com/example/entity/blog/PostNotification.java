package com.example.entity.blog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.entity.Base;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "post_notification")
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class PostNotification extends Base {
	@Column(name = "title")
	private String title;
	@Column(name = "content", columnDefinition = "NTEXT")
	private String content;

	//TODO: Đây là phần thông báo của hệ thống tới sinh viên 07/11/2023
	
}
