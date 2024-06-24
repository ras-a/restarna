package jp.co.creambakery.bean;

import java.util.*;

import jp.co.creambakery.entity.*;

/**
 * ItemBeanFactory
 */
public class BeanFactory
{
	private Map<Integer, ItemBean> items = new HashMap<>();
	public ItemBean createBean(Item entity)
	{
		if (entity == null)
			return null;
		
		ItemBean bean;

		bean = items.get(entity.getId());
		if (bean == null)
		{
			if (entity.getStore() != null)
			{
				bean = new StoreItemBean(entity.getStore());
			}
			else
			{
				bean = new CustomItemBean(entity.getCustom());
			}
			items.put(bean.getId(), bean);
			bean.setBread(createBean(entity.getBread()));
			bean.setCreams(createCreamList(entity.getCreams()));
			bean.setReviews(createReviewList(entity.getReviews()));
		}

		return bean;
	}
	public List<ItemBean> createItemList (List<Item> entities)
	{
		if (entities == null)
			return new ArrayList<>();
		List<ItemBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}
	public List<CustomItemBean> createCustomItemList (List<Item> entities)
	{
		if (entities == null)
			return new ArrayList<>();
		List<CustomItemBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add((CustomItemBean)createBean(entity));

		return list;
	}

	private Map<Integer, BreadBean> breads = new HashMap<>();
	public BreadBean createBean(Bread entity)
	{
		if (entity == null)
			return null;

		BreadBean bean = breads.get(entity.getId());
		if (bean == null)
		{
			bean = new BreadBean(entity);
			breads.put(bean.getId(), bean);
		}


		return bean;
	}
	public List<BreadBean> createBreadList (List<Bread> entities)
	{
		if (entities == null)
			return new ArrayList<>();
		List<BreadBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}

	private Map<Integer, CreamBean> creams = new HashMap<>();
	public CreamBean createBean(Cream entity)
	{
		if (entity == null)
			return null;

		CreamBean bean = creams.get(entity.getId());
		if (bean == null)
		{
			bean = new CreamBean(entity);
			creams.put(bean.getId(), bean);
		}


		return bean;
	}
	public List<CreamBean> createCreamList (List<Cream> entities)
	{
		if (entities == null)
			return new ArrayList<>();
		List<CreamBean> list = new ArrayList<>(entities.size());
		for (var entity : entities)
		{
			list.add(createBean(entity));
		}

		return list;
	}

	private Map<Integer, UserBean> users = new HashMap<>();
	public UserBean createBean(User entity)
	{
		if (entity == null)
			return null;

		var bean = users.get(entity.getId());
		if (bean == null)
		{
			bean = new UserBean(entity);
			users.put(bean.getId(), bean);
			bean.setAddresses(createAddressList(entity.getAddresses()));
			bean.setMainAddress(createBean(entity.getMainAddress()));
			bean.setCreditCards(createCreditCardList(entity.getCreditCards()));
			bean.setMainCreditCard(createBean(entity.getMainCreditCard()));
			bean.setFavorites(createItemList(entity.getFavorites()));
			bean.setReviews(createReviewList(entity.getReviews()));
			bean.setCart(createCartList(entity.getCart()));
			bean.setOrders(createOrderList(entity.getOrders()));
			
			List<Item> created = new ArrayList<>();
			for (var entry: entity.getCreatedItems())
			{
				created.add(entry.getItem());
			}
			bean.setCreatedItems(createCustomItemList(created));
		}

		return bean;
	}
	public List<UserBean> createUserList (List<User> entities)
	{
		if (entities == null)
			return new ArrayList<>();
		List<UserBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}

	private Map<Integer, AddressBean> addressProfiles = new HashMap<>();
	public AddressBean createBean(AddressProfile entity)
	{
		if (entity == null)
			return null;
		var bean = addressProfiles.get(entity.getId());
		if (bean == null)
		{
			bean = new AddressBean(entity);
			addressProfiles.put(bean.getId(), bean);
			bean.setUser(createBean(entity.getUser()));
		}

		return bean;
	}
	public List<AddressBean> createAddressList (List<AddressProfile> entities)
	{
		if (entities == null)
			return new ArrayList<>();
		List<AddressBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}

	private Map<Long, ReviewBean> reviews = new HashMap<>();
	public ReviewBean createBean(Review entity)
	{
		if (entity == null)
			return null;

		long key = entity.getPoster().getId()<< 32 + entity.getItem().getId();

		var bean = reviews.get(key);
		if (bean == null)
		{
			bean = new ReviewBean(entity);
			reviews.put(key, bean);
			bean.setPoster(createBean(entity.getPoster()));
			bean.setItem(createBean(entity.getItem()));
		}

		return bean;
	}
	public List<ReviewBean> createReviewList (List<Review> entities)
	{
		if (entities == null)
			return new ArrayList<>();
		List<ReviewBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}
	
	public AdminBean createBean(Admin entity)
	{
		if (entity == null)
			return null;

		return new AdminBean(entity);
	}

	private Map<Integer, CreditCardBean> creditCards = new HashMap<>();
	public CreditCardBean createBean(CreditCard entity)
	{
		if (entity == null)
			return null;

		var bean = creditCards.get(entity.getId());
		if (bean == null)
		{
			bean = new CreditCardBean(entity);
			creditCards.put(bean.getId(), bean);
			bean.setOwner(createBean(entity.getOwner()));
		}

		return bean;
	}
	public List<CreditCardBean> createCreditCardList (List<CreditCard> entities)
	{
		if (entities == null)
			return new ArrayList<>();
		List<CreditCardBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}

	private Map<Long, CartBean> cart = new HashMap<>();
	public CartBean createBean(Cart entity)
	{
		if (entity == null)
			return null;

		long key = entity.getUser().getId()<< 32 + entity.getItem().getId();

		var bean = cart.get(key);
		if (bean == null)
		{
			bean = new CartBean(entity);
			cart.put(key, bean);
			bean.setItem(createBean(entity.getItem()));
		}

		return bean;
	}

	public List<CartBean> createCartList (List<Cart> entities)
	{
		if (entities == null)
			return new ArrayList<>();
		List<CartBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}
	
	private Map<Integer, OrderBean> orders = new HashMap<>();
	public OrderBean createBean(ProductOrder entity)
	{
		if (entity == null)
			return null;

		var bean = orders.get(entity.getId());
		if (bean == null)
		{
			bean = new OrderBean(entity);
			orders.put(bean.getId(), bean);
			bean.setAddress(createBean(entity.getAddress()));
			bean.setCreditCard(createBean(entity.getCreditCard()));
			bean.setUser(createBean(entity.getUser()));
		}

		return bean;
	}
	public List<OrderBean> createOrderList (List<ProductOrder> entities)
	{
		if (entities == null)
			return new ArrayList<>();
		List<OrderBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}
}