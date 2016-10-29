package com.pskindero.javaee.ejb.beans_lifecycle.stateful;

import javax.ejb.Remote;

@Remote
public interface RemoteStatefulInterface {

	String getRemoteMessage();
}
