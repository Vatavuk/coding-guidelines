package hr.com.vgv.examples.business_logic;

import java.util.ArrayList;

public interface UseCase
{

    void storePayloads(UserSource userSource, String message);

    class Procedural implements UseCase {

        private static final String TOPIC = "payloads";

        private PayloadAdapter adapter;

        private Users users;

        private Queue queue;

        @Override
        public void storePayloads(UserSource userSource, String message)
        {
            User user = fetchOrCreateUser(userSource);
            Iterable<Payload> payloads = adapter.convert(message);
            for (Device device: user.devices()) {
                device.storePayloads(payloads);
            }
            byte[] compressed = new CompressedPayloads(payloads).value();
            addToQueue(userSource.topic(), compressed);
        }

        private User fetchOrCreateUser(UserSource userSource)
        {
            String id = userSource.id();
            User user;
            if (this.users.exists(id)) {
                user  = this.users.get(id);
            } else {
                user = this.users.create(userSource);
            }
            return user;
        }

        private void addToQueue(String topic, byte[] payload) {
            if (validTopic(topic)) {
                this.queue.add(topic, payload);
            } else {
                this.queue.add(TOPIC, payload);
            }
        }

        private boolean validTopic(String topic) {
            return topic != null && !topic.isEmpty();
        }
    }

    class Oop implements UseCase {

        @Override
        public void storePayloads(UserSource userSource, String message)
        {

        }
    }
}
