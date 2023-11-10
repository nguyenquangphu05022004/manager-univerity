package com.example.Service.imp.blog;

import java.util.List;

import com.example.Service.imp.search.GenericSearchBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.GenericService;
import com.example.converter.imp.blog.PostNotificationConverter;
import com.example.dto.blog.PostNotificationDTO;
import com.example.entity.blog.PostNotification;
import com.example.repository.blog.PostNotificationRepository;

@Service
public class PostNotificationService implements GenericService<PostNotificationDTO> {

    @Autowired
    private PostNotificationRepository postNotificationRepository;

    @Autowired
    private PostNotificationConverter postNotificationConverter;

    @Override
    public PostNotificationDTO save(PostNotificationDTO object) {
        PostNotification postNotification = null;
        if (object.getId() != null) {
            PostNotification oldPost =
                    (PostNotification) GenericSearchBy
                            .findOneById(
                                    "PostNotification",
                                    object.getId(),
                                    postNotificationRepository);
            postNotification = postNotificationConverter.toEntity(oldPost, object);
        } else {
            postNotification = postNotificationConverter.toEntity(object);
        }
        return postNotificationConverter
                .toDto(postNotificationRepository.save(postNotification));
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            delete(id);
        }
        // TODO 06/11/2023
    }

    @Override
    public List<PostNotificationDTO> list() {
        List<PostNotification> posts = postNotificationRepository.findAll();
        return postNotificationConverter.dtoList(posts);
    }

    public void delete(Long id) {
        postNotificationRepository.delete(id);
    }




}
