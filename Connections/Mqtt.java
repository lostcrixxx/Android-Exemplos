// import
implementation 'org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5'
implementation 'org.eclipse.paho:org.eclipse.paho.android.service:1.1.1'

// manifest
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<application>
	...
	<service android:name="org.eclipse.paho.android.service.MqttService" />
</application>

// class
public class MqttHandler {

    private MqttClient client;

    public void connect(String brokerUrl, String clientId) {
        try {
            // Set up the persistence layer
            MemoryPersistence persistence = new MemoryPersistence();

            // Initialize the MQTT client
            client = new MqttClient(brokerUrl, clientId, persistence);

            // Set up the connection options
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);

            // Connect to the broker
            client.connect(connectOptions);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void publish(String topic, String message) {
        try {
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            client.publish(topic, mqttMessage);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(String topic) {
        try {
            client.subscribe(topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}

// implementation
private MqttHandler mqttHandler;

mqttHandler = new MqttHandler();
mqttHandler.connect(BROKER_URI, CLIENT_ID);
subscribeToTopic("/test");
publishMessage("/test", "ok");

private void publishMessage(String topic, String message) {
	Toast.makeText(this, "Publishing message: " + message, Toast.LENGTH_LONG).show();
	mqttHandler.publish(topic, message);
}

private void subscribeToTopic(String topic) {
	Toast.makeText(this, "Subscribe message: " + topic, Toast.LENGTH_LONG).show();
	mqttHandler.subscribe(topic);
}

@Override
protected void onDestroy() {
	mqttHandler.disconnect();
	super.onDestroy();
}
	

