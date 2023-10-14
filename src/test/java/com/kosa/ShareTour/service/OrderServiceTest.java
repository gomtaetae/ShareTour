package com.kosa.ShareTour.service;

import com.kosa.ShareTour.constant.ItemSellStatus;
import com.kosa.ShareTour.dto.OrderDto;
import com.kosa.ShareTour.entity.Item;
import com.kosa.ShareTour.entity.Order;
import com.kosa.ShareTour.entity.Member;
import com.kosa.ShareTour.entity.OrderItem;
import com.kosa.ShareTour.repository.ItemRepository;
import com.kosa.ShareTour.repository.MemberRepository;
import com.kosa.ShareTour.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.kosa.ShareTour.constant.OrderStatus;
import javax.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private  OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    MemberRepository memberRepository;

    public Item saveItem(){
        Item item = new Item();
        item.setTitle("테스트상품");
        item.setTotalPrice(10000);
        item.setContent("테스트 상품 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setInStock(100);
        return itemRepository.save(item);
    }

    public Member saveMember(){
        Member member = new Member();
        member.setEmail("test@test.com");
        member.setAddress("우리집이당");
        member.setGrade("3급");
        member.setGender("여성");
        member.setBirthday(LocalDate.now());
        member.setMobile("01041597647");
        member.setPassword("1234");
        member.setNickname("dusdn4159");
        member.setUsername("duswl");
        return memberRepository.save(member);
    }

    @Test
    @DisplayName("주문 테스트")
    public void order(){
        Item item = saveItem();
        Member member = saveMember();

        OrderDto orderDto = new OrderDto();
        orderDto.setCount(10);
        orderDto.setItemId(item.getId());

        Long orderId = orderService.order(orderDto, member.getEmail());
        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);

        List<OrderItem> orderItems = order.getOrderItems();

        int totalPrice = orderDto.getCount()*item.getTotalPrice();

        assertEquals(totalPrice, order.getTotalPrice());
    }

    @Test
    @DisplayName("주문 취소 테스트")
    public void cancelOrder(){
        Item item = saveItem();
        Member member = saveMember();

        OrderDto orderDto = new OrderDto();
        orderDto.setCount(10);
        orderDto.setItemId(item.getId());
        Long orderId = orderService.order(orderDto, member.getEmail());

        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        orderService.cancelOrder(orderId);

        assertEquals(OrderStatus.CANCEL, order.getOrderStatus());
        assertEquals(100, item.getInStock());
    }

}