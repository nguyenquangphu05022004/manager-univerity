package com.example.dto.blog;

import com.example.dto.GenericDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class PostNotificationDTO extends GenericDTO {
	
	private String title;
	private String content;
	
}
