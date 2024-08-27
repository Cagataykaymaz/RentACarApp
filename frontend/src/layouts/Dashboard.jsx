import React from 'react';
import Categories from './Categories';
import ProductList from '../pages/ProductList';
import { Grid } from 'semantic-ui-react';
import { Route, Routes } from 'react-router-dom';
import ProductDetail from '../pages/ProductDetail';
import CartDetail from '../pages/CartDetail';
import { ToastContainer } from 'react-toastify';
import ProductAdd from '../pages/ProductAdd';

export default function Dashboard() {
  return (
    <div>
      <ToastContainer position='bottom-right'/>
      <Grid>
        <Grid.Row>
          <Grid.Column width={4}>
            <Categories />
          </Grid.Column>
          <Grid.Column width={12}>
            <Routes>
              <Route path='/' element={<ProductList/>} />
              <Route path='/products' element={<ProductList/>} />
              <Route path='/products/:name' element={<ProductDetail/>} />
              <Route path='/cart' element={<CartDetail/>} />
              <Route path='/product/add' element={<ProductAdd/>} />
            </Routes>
          </Grid.Column>
        </Grid.Row>
      </Grid>
    </div>
  );
}