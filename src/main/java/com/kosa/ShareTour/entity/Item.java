package com.kosa.ShareTour.entity;

import com.kosa.ShareTour.constant.ItemSellStatus;
import com.kosa.ShareTour.exception.OutOfStockException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    @Column(name="start_date", nullable = false)
    private LocalDate startDate;

    @Column(name="end_date", nullable = false)
    private LocalDate endDate;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="modified_at")
    private LocalDateTime modifiedAt;

    @Column(name="img", nullable = false)
    private String img;

    @Column(name="totalprice", nullable = false)
    private Integer totalPrice;

    @Column(name="duration", nullable = false)
    private Integer duration;

    @Column(name="expire")
    private LocalDateTime expire;

    @Column(name="in_stock")
    private Integer inStock;

    @Column(name="stock_left")
    private Integer stockLeft;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;    //패키지 판매 상태

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
    public void removeStock(int stockNumber){
        int restStock = this.stockNumber - stockNumber;
        if(restStock<0){
            throw new OutOfStockException("상품의 재고가 부족 합니다.(현재 재고 수량: " + this.stockNumber+")");
        }
        this.stockNumber = restStock;
    }
    public void addStock(int stockNumber){
        this.stockNumber += stockNumber;
    }
}