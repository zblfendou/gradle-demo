package com.springjms.service;

import javax.jms.Destination;
import java.io.Serializable;

/**
 * Created by Administrator on 2016.4.20.
 */
public interface ProducerService {
	void sendMessage (Destination destination, String message);

}
