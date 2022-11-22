package it.contrader.utils;

import java.util.Map;

public class CartSingleton {

    /**
     * Cart
     * map
     *          < "product_"+id_product,
     *              <
     *                  product_name,
     *                  quantity,
     *                  unit_price,
     *                  total
     *              >
     */
    private Map<String, Map<String, String>> cart;

    private float total;

    private static CartSingleton userSingleton = null ;

    /**
     * Aggiungi/diminuisci quantità con selettore più o meno
     * @param id_product
     * @param product_name
     * @param action ["up","down"]
     * @param unit_price
     */
    public void cartProductUpdate(int id_product, String product_name, String action, Float unit_price) {
        if (action == "up" && action == "down") {
            int qty = (action=="up")?1:-1;
            Map currentCart = this.cart;
            String key = "product_"+String.valueOf(id_product);
            if (currentCart.containsKey(key)) {
                Map cartProduct = (Map)currentCart.get(key);
            }
        }
    }

    public void setCart(Map cart) {
        this.cart = cart;
    }

    public Map getCart(){
        return this.cart;
    }

    private CartSingleton() {
    }

    public static CartSingleton getInstance(){
        if (userSingleton == null) {
            userSingleton = new CartSingleton();
        }
        return userSingleton;
    }

    public static void initSingleton () {
        userSingleton = null;
    }
}