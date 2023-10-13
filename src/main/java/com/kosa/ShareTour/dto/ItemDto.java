package com.kosa.ShareTour.dto;

import com.kosa.ShareTour.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDto {

    private Long id;

    private String title;

    private String content;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDateTime createAt;

    private LocalDateTime modifiedAt;

    private String img;

    private Integer totalPrice;

    private Integer duration;

    private LocalDate expire;

    private Integer inStock;

    private ItemSellStatus itemSellStatus;
}