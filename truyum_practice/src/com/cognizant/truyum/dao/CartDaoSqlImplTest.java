/**
 * 
 */
package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * @author udhy
 *
 */
public class CartDaoSqlImplTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws CartEmptyException {
		// TODO Auto-generated method stub

		testAddCartItem();

		testRemoveCartItem();
		testGetAllCartItems();

	}

	static void testAddCartItem() throws CartEmptyException {

		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		CartDao cartDao = cartDaoSqlImpl;
		cartDao.addCartItem(2, 4);
		cartDao.addCartItem(2, 3);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(2);
		System.out.println("MenuItem list :" + menuItemList);

	}

	static void testGetAllCartItems() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		CartDao cartDao = cartDaoSqlImpl;

		List<MenuItem> menuItemList = cartDao.getAllCartItems(2);
		System.out.println("MenuItem list :" + menuItemList);
	}

	static void testRemoveCartItem() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		CartDao cartDao = cartDaoSqlImpl;

		try {
			cartDao.removeCartItem(2, 4);
			List<MenuItem> menuItemList = cartDao.getAllCartItems(2);
			System.out.println("MenuItem list after removed:" + menuItemList);
		} catch (Exception e) {
			throw new CartEmptyException("Cart is empty");
		}

	}


}
