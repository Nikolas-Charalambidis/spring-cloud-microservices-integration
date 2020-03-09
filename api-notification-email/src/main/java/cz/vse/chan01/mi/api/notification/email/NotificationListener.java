package cz.vse.chan01.mi.api.notification.email;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.DefaultKafkaHeaderMapper;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Component;

import cz.vse.chan01.swagger.notification.model.Notification;
import cz.vse.chan01.swagger.notification.model.NotificationType;
import cz.vse.chan01.swagger.notification.model.NotificationType.TypeEnum;

@Component
public class NotificationListener implements AcknowledgingMessageListener<String, Notification> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

	private final DefaultKafkaHeaderMapper kafkaHeaderMapper;

	public NotificationListener(final DefaultKafkaHeaderMapper kafkaHeaderMapper) {
		this.kafkaHeaderMapper = kafkaHeaderMapper;
	}

	@KafkaListener(topics = "document-topic")
	public void onMessage(final ConsumerRecord<String, Notification> record, final Acknowledgment acknowledgment) {

		final Notification payload = record.value();
		final Map<String, Object> customHeaders = new HashMap<>();
		kafkaHeaderMapper.toHeaders(record.headers(), customHeaders);

		final String correlationId = (String) customHeaders.get(KafkaHeaders.CORRELATION_ID);
		final String topic = record.topic();

		final String emailList = payload.getNotificationType().stream()
			.filter(notificationType -> TypeEnum.EMAIL.equals(notificationType.getType()))
			.map(NotificationType::getValue)
			.collect(Collectors.joining(", "));

		LOGGER.info("[{}] Requested Email Notification with id={} from {} to {}", correlationId, payload.getNotificationId(), topic, emailList);

		this.sendNotification(payload);

		acknowledgment.acknowledge();
	}

	private void sendNotification(@SuppressWarnings("unused") Notification notification) {
		try {
			// SEND NOTIFICATION
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
