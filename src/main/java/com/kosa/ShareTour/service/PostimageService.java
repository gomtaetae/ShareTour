package com.kosa.ShareTour.service;

import com.kosa.ShareTour.entity.Postimage;
import com.kosa.ShareTour.repository.PostimageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class PostimageService {

    @Value("${postimageLocation}")
    private String postimageLocation;

    private final PostimageRepository postimageRepository;

    private final FileService fileService;

    public void savePostimage(Postimage postimage, MultipartFile postimageFile) throws Exception {
        String oriImgName = postimageFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        if (!StringUtils.isEmpty(oriImgName)) {
            imgName = fileService.uploadFile(postimageLocation, oriImgName, postimageFile.getBytes());
            imgUrl = "/images/posting/" + imgName;
        }

        postimage.updatePostimage(oriImgName, imgName, imgUrl);
        postimageRepository.save(postimage);
    }

//    public void updatePostimage(Long postimageId, MultipartFile postimageFile) throws Exception {
//        if(!)
//    }

}
