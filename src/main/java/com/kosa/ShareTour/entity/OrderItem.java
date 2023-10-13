package com.kosa.ShareTour.entity;

public class OrderItem extends BaseEntity{
    public static OrderItem createOrderItem(Item item, int count){
        OrderItem orderItem= new OrderItem();
        orderItem.setItem(item);
        orderItem.sdtCount(count);
        orderItem.setOrderPrice(item.getPrice());

        item.removeStock(count);
        return  orderItem;
    }

        public int getTotalPrice(){
            return orderPrice*count;
        }
    public void cancel() {
        this.getItem().addStock(count);
    }
}
