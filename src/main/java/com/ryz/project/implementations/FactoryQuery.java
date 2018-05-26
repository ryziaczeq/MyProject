package com.ryz.project.implementations;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.ryz.project.domain.User;

public class FactoryQuery {

	Class<User> t = User.class;
	private EntityManager entityManager;
	public FactoryQuery(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}
	public <T> CriteriaQuery<T> returnQuery(Map<String,String> queryHashMap, Class <T> type){
		
		CriteriaQuery<T> query = createQuery(type);
		if (queryHashMap.get("action") == "select")
			selectItemQuery(query, queryHashMap);
		if (queryHashMap.get("comparator") != null)
			WhereQuery(query, queryHashMap);
		
		return query;
	}
	
	private <T> CriteriaQuery<T> createQuery(Class<T> type) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(type);
		return query;
	}
	private <T> void selectItemQuery(CriteriaQuery<T> query, Map<String,String> queryHashMap){
		String item = queryHashMap.get("item");
		Root<User> root = query.from(User.class);
		if (item == "users")
			query.select((Selection<T>) root);
		else	
			query.select(root.get(item));
	}
	
	private <T> void WhereQuery(CriteriaQuery<T> query, Map<String,String> queryHashMap){
		String comparator = queryHashMap.get("comparator");
		String parameter = queryHashMap.get("parameter");
		String value = queryHashMap.get("value");
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		Root<User> root = query.from(User.class);
		if (comparator == ">")
			query.where(builder.greaterThan(root.get(parameter), value));
		else if (comparator == "<")
			query.where(builder.lessThan(root.get(parameter), value));
		else
			query.where(builder.equal(root.get(parameter), value));
	}

}
