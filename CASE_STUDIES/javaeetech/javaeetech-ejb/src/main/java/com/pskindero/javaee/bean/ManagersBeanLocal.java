package com.pskindero.javaee.bean;

import java.util.List;

import javax.ejb.Local;

import com.pskindero.javaee.javaeetech.jpa.entity.Manager;

@Local
public interface ManagersBeanLocal {

	List<Manager> getManagers();

	Manager getManager(Integer id);
}
