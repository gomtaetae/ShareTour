package com.kosa.ShareTour.controller;

import com.kosa.ShareTour.dto.OrderDto;
import com.kosa.ShareTour.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Principal;
import javax.util.List;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService;

    @PostMapping(value = "/order")
    public @ResponseBody ResponseEntity order (@RequestBody @Valid OrderDto orderDto, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            StringBuilder sb =new StringBuilder();
            List<FieldError> fieldErrors =bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors){
                sb.append((fieldError.getDefaultMessage());
            }
            return new ResponseEntity<String>(sb.toString(),HttpStatus.BAD_REQUEST);
        }
        String email = principal.getName();
        Long orderId;
        try{
            orderId = orderService.order(orderDto, email);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<Long>(orderId, HttpStatus.OK);
    }
    @GetMapping(value = {"/orders" , "/orders/{page}"})
    public String orderHist(@PathVariable("page") Opstional<Integer>Page, Principal principal,Model medel){
        Pageable pageable = PageRequest.of(page.isPresent()? page.get() : 0,4);

        Page<OrderHisDto> orderHisDtoList = orderService.getOrderList(principal.getName(),pageable);

            model.addAttribute("orders", ordersHisDtoList);
            model.addAttribute("page", pageable.getPageNumber());
            model.addAttribute("maxPage", 5);

            return "order/orderHist";
    }
    @PostMapping("/order/{orderId}/cancel")
    public @ResponseBody ResponseEntity cancelOrder(@PathVariable("orderId") Long orderId, Principal principal){
        if(!orderService.validateOrder(orderId, principal.getName())){
            return new ResponseEntity<String>("주문 취소 권한이 없습니다", HttpStatus.FORBIDDEN);

        }
        orderService.cancelOrder(orderId);
        return new ResponseEntity<Long>(orderId, HttpStatus.OK);
    }
}
