package com.danan.intg.mqtt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.junit.Before;
import org.junit.Test;

public class MQTTTesting {

	private final static Log LOG = LogFactory.getLog(MQTTTesting.class);
	private MqttClient mc = null;
	private MqttClientPersistence mcp = null;

	private String topic = "MQTT Examples";
	private String content = "Message from MqttPublishSample";
	private int qos = 2;
	private String broker = "tcp://localhost:1883";
	private String clientId = "JavaSample";

	@Before
	public void init() {
		mcp = new MemoryPersistence();
		try {
			mc = new MqttClient(broker, clientId, mcp);
		} catch (MqttException e) {
			LOG.error("init MQTT Client failed");
			System.exit(-1);
		}
	}

	@Test
	public void sendMessageSuccess() {
		MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
		mqttConnectOptions.setCleanSession(true);
		mqttConnectOptions.setConnectionTimeout(5000);
		try {
			mc.connect(mqttConnectOptions);
			MqttMessage mqttMessage = new MqttMessage("Hello ActiveMQ MQTT ".getBytes());
			mqttMessage.setQos(qos);
			mc.publish(topic, mqttMessage);
			mc.disconnect();
		} catch (MqttSecurityException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

}
