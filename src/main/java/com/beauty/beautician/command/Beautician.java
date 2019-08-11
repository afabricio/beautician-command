package com.beauty.beautician.command;

import java.lang.reflect.Field;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beautician {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setByMap(Map<String, String> map) {

		Class<Beautician> clazz = Beautician.class;

		map.entrySet().forEach(e -> {

			try {
				Field fieldID = clazz.getDeclaredField(e.getKey());

				fieldID.set(this, e.getValue());

			} catch (NoSuchFieldException e1) {

				throw new RuntimeException("field " + e.getKey() + " not exists in " + clazz.getName());
			} catch (IllegalArgumentException e1) {
				throw new RuntimeException("Invalid value ("+e.getValue()+") for field " + e.getKey() + " in " + clazz.getName());
			} catch (IllegalAccessException e1) {
				throw new RuntimeException("Can not access field " + e.getKey() + " in " + clazz.getName());
			}

		});

	}

}
