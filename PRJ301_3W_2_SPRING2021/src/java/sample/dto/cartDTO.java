/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ACER
 */
public class cartDTO {
    private Map<String, TeaDTO> cart;
    public cartDTO()
    {}

    public cartDTO(Map<String, TeaDTO> cart) {
        this.cart = cart;
    }

    public Map<String, TeaDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, TeaDTO> cart) {
        this.cart = cart;
    }
    public void add(TeaDTO tea)
    {
        if(cart==null)
        {
            cart = new HashMap<>();
        }
        if(cart.containsKey(tea.getId()))
        {
            int quantity = cart.get(tea.getId()).getQuantity();
            tea.setQuantity(quantity+ tea.getQuantity());
        }
        cart.put(tea.getId(), tea);
    }
    public void delete(String id)
    {
        if(cart==null)
        {
            return ;
        }
        if(cart.containsKey(id))
        {
            cart.remove(id);
        }
    }
    public void update(String id , TeaDTO tea)
    {
        if(cart==null)
        {
            return;
        }
        if(cart.containsKey(id))
        {
            cart.replace(id, tea);
        }
    }
    
}
