package jp.co.creambakery.bean;

import java.util.*;
import jp.co.creambakery.entity.*;

/**
 * ItemBeanFactory
 */
public class BeanFactory{
	private HashMap<Integer, ItemBean> items = new HashMap<>();
	public ItemBean createBean(Item entity)
	{
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
		List<ItemBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}

	private HashMap<Integer, BreadBean> breads = new HashMap<>();
	public BreadBean createBean(Bread entity)
	{
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
		List<BreadBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}

	private HashMap<Integer, CreamBean> creams = new HashMap<>();
	public CreamBean createBean(Cream entity)
	{
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
		List<CreamBean> list = new ArrayList<>(entities.size());
		for (var entity : entities)
		{
			list.add(createBean(entity));
		}

		System.out.println(list);
		return list;
	}

	private HashMap<Integer, CustomerBean> customers = new HashMap<>();
	public CustomerBean createBean(Customer entity)
	{
		var bean = customers.get(entity.getId());
		if (bean == null)
		{
			bean = new CustomerBean(entity);
			customers.put(bean.getId(), bean);
			bean.setAddresses(createAddressList(entity.getAddresses()));
			bean.setCreditCards(createCreditCardList(entity.getCreditCards()));
			bean.setFavorites(createItemList(entity.getFavorites()));
			bean.setReviews(createReviewList(entity.getReviews()));
		}

		return bean;
	}
	public List<CustomerBean> createCustomerList (List<Customer> entities)
	{
		List<CustomerBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}

	private HashMap<Integer, AddressBean> addressProfiles = new HashMap<>();
	public AddressBean createBean(AddressProfile entity)
	{
		var bean = addressProfiles.get(entity.getId());
		if (bean == null)
		{
			bean = new AddressBean(entity);
			addressProfiles.put(bean.getId(), bean);
			bean.setCustomer(createBean(entity.getCustomer()));
		}

		return bean;
	}
	public List<AddressBean> createAddressList (List<AddressProfile> entities)
	{
		List<AddressBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}

	private HashMap<Long, ReviewBean> reviews = new HashMap<>();
	public ReviewBean createBean(Review entity)
	{
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
		List<ReviewBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}
	
	public AdminBean createBean(Admin entity)
	{
		return new AdminBean(entity);
	}

	private HashMap<Integer, CreditCardBean> creditCards = new HashMap<>();
	public CreditCardBean createBean(CreditCard entity)
	{
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
		List<CreditCardBean> list = new ArrayList<>(entities.size());

		for (var entity : entities)
			list.add(createBean(entity));

		return list;
	}
}