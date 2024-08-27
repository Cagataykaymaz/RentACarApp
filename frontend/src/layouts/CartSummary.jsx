import React from 'react';
import { useSelector } from 'react-redux';
import { NavLink } from 'react-router-dom';
import { Dropdown, DropdownItem, DropdownMenu,Label } from 'semantic-ui-react';

export default function CartSummary() {
  const { cartItems } = useSelector(state => state.cart);

  return (
    <div>
      <Dropdown item text='Sepetiniz'>
        <DropdownMenu>
          {cartItems && cartItems.length > 0 ? (
            cartItems.map((cartItem, index) => (
              cartItem.product ? (
                <DropdownItem key={index}>
                  {cartItem.product.productName} <Label>{cartItem.quantity}</Label>
                </DropdownItem>
              ) : null
            ))
          ) : (
            <DropdownItem>Sepetiniz boş</DropdownItem>
          )}
          <Dropdown.Divider />
          <DropdownItem as={NavLink} to='cart'>Sepete git</DropdownItem>
        </DropdownMenu>
      </Dropdown>
    </div>
  );
}