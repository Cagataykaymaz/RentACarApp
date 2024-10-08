import { cartItems } from "../initialValues/cartItems";
import { ADD_TO_CART, REMOVE_FROM_CART } from "../actions/cartActions";

const initialState = {
  cartItems: cartItems
};

export default function cartReducer(state = initialState, { type, payload }) {
  switch (type) {
    case ADD_TO_CART:
      let product = state.cartItems.find(c => c.product.id === payload.id);
      if (product) {
        // Eğer ürün zaten varsa, miktarını artır
        return {
          ...state,
          cartItems: state.cartItems.map(item =>
            item.product.id === payload.id
              ? { ...item, quantity: item.quantity + 1 }
              : item
          )
        };
      } else {
        // Yeni bir ürün ekle
        return {
          ...state,
          cartItems: [...state.cartItems, { quantity: 1, product: payload }]
        };
      }

    case REMOVE_FROM_CART:
      return {
        ...state,
        cartItems: state.cartItems.filter(c => c.product.id !== payload.id)
      };

    default:
      return state;
  }
}