package com.kosa.ShareTour.entity;

import com.kosa.ShareTour.constant.ItemSellStatus;
import com.kosa.ShareTour.dto.ItemFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.kosa.ShareTour.exception.OutOfStockException;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;       //패키지 이름

    @Column(name = "content", columnDefinition = "LONGTEXT", nullable = false)
    private String content;       //패키지 설명

    @Column(name = "img")
    private String img;

    @Column(name = "totalprice", nullable = false)
    private Integer totalPrice;

    @Column(name = "in_stock", nullable = false)//재고수량
    private Integer inStock;

    @Column(name = "stock_left")
    private Integer stockLeft;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;    //패키지 판매 상태

    public void updateItem(ItemFormDto itemFormDto) {

        this.title = itemFormDto.getTitle();
        this.content = itemFormDto.getContent();
        this.totalPrice = itemFormDto.getTotalPrice();
        this.inStock = itemFormDto.getInStock();
        this.stockLeft = itemFormDto.getStockLeft();
        this.itemSellStatus = itemFormDto.getItemSellStatus();

    }
//    @ManyToOne
//    @JoinColumn(name="places_id")
//    private Place place;
//
//    @ManyToOne
//    @JoinColumn(name="landmarks_id")
//    private Landmark landmark;
//
//    @ManyToOne
//    @JoinColumn(name="accommodations_id")
//    private Accommodation accommodation;
//
//    @ManyToOne
//    @JoinColumn(name="restaurants_id")
//    private Restaurant restaurant;

        public void removeStock ( int inStock){
            int restStock = this.inStock - inStock;
            if (restStock < 0) {
                throw new OutOfStockException("상품의 재고가 부족 합니다.(현재 재고 수량: " + this.inStock + ")");
            }
            this.inStock = restStock;
        }

        public void addStock(int inStock){
            this.inStock += inStock;

    }
}

