(ns super-app.simple-jms
  (:import [org.apache.activemq ActiveMQConnectionFactory])
  (:import [javax.jms Session])
  (:gen-class))

(defn send-to-queue [queue text-message]
  (let [connFactory (new ActiveMQConnectionFactory)
        connection (.createConnection connFactory)
        session (.createSession connection false Session/AUTO_ACKNOWLEDGE)
        destination (.createQueue session queue)
        producer (.createProducer session destination)
        message (.createTextMessage session text-message)]
    (do
      (.send producer message)
      (.close connection))))

(defn receive-from-queue [queue]
  (let [connFactory (new ActiveMQConnectionFactory)
        connection (.createConnection connFactory)
        session (.createSession connection false Session/AUTO_ACKNOWLEDGE)
        destination (.createQueue session queue)
        consumer (.createConsumer session destination)
        message (.receive consumer)]
    (do
      (.close connection)
      message)))