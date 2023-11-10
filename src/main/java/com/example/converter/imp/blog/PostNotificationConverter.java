package com.example.converter.imp.blog;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.converter.GenericConverter;
import com.example.dto.blog.PostNotificationDTO;
import com.example.entity.blog.PostNotification;

@Component
public class PostNotificationConverter implements GenericConverter<PostNotification, PostNotificationDTO> {

	@Override
	public PostNotification toEntity(PostNotificationDTO dto) {
		// TODO Auto-generated method stub
		return PostNotification.builder()
				.title(dto.getTitle())
				.content(dto.getContent())
				.build();
	}

	@Override
	public PostNotificationDTO toDto(PostNotification entity) {
		// TODO Auto-generated method stub
		return PostNotificationDTO.builder()
				.title(entity.getTitle())
				.content(entity.getContent())
				.id(entity.getId())
				.createDate(entity.getCreateDate())
				.createBy(entity.getCreateBy())
				.modifiedBy(entity.getModifiedBy())
				.modifiedDate(entity.getModifiedDate())
				.build();
	}

	@Override
	public PostNotification toEntity(PostNotification entity, PostNotificationDTO dto) {
		return entity.toBuilder()
				.title(dto.getTitle())
				.content(dto.getContent())
				.build();
	}

	@Override
	public PostNotificationDTO toDto(PostNotificationDTO dto, PostNotification entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostNotificationDTO> dtoList(List<PostNotification> entityList) {
		// TODO Auto-generated method stub
		return entityList
				.stream()
				.map((e) -> toDto(e))
				.collect(Collectors.toList());
	}

}
