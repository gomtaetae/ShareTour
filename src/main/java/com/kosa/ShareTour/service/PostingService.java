package com.kosa.ShareTour.service;

import com.kosa.ShareTour.dto.PostingFormDto;
import com.kosa.ShareTour.entity.Posting;
import com.kosa.ShareTour.entity.Postimage;
import com.kosa.ShareTour.repository.MemberRepository;
import com.kosa.ShareTour.repository.PostimageRepository;
import com.kosa.ShareTour.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;
    private final PostimageService postimageService;
    private final PostimageRepository postimageRepository;
    private final MemberRepository memberRepository;

    public Long savePosting(PostingFormDto postingFormDto,
                            List<MultipartFile> postimageFileList,
                            String email)
            throws Exception{

        var member = memberRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
        //상품 등록
        Posting posting = postingFormDto.createPosting();
        posting.setMember(member);
        postingRepository.save(posting);

        //이미지 등록
        for(int i=0; i < postimageFileList.size(); i++){
            Postimage postimage = new Postimage();
            postimage.setPosting(posting);

            if(i == 0)
                postimage.setRepimgYn("Y");
            else
                postimage.setRepimgYn("N");

            postimageService.savePostimage(postimage, postimageFileList.get(i));
        }

        return posting.getId();

    }


}
