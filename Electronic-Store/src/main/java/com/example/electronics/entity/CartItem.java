package com.example.electronics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // Getters and Setters
    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // 🔨 Manual Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Product product;
        private int quantity;
        private int totalPrice;
        private Cart cart;

        public Builder product(Product product) {
            this.product = product;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder totalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder cart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public CartItem build() {
            CartItem item = new CartItem();
            item.setProduct(this.product);
            item.setQuantity(this.quantity);
            item.setTotalPrice(this.totalPrice);
            item.setCart(this.cart);
            return item;
        }
    }
}
