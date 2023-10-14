package com.kosa.ShareTour.repository;


import com.kosa.ShareTour.dto.ItemSearchDto;
import com.kosa.ShareTour.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {
    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
