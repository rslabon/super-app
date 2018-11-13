(ns super-app.core
  (:require [super-app.person :as person])
  (:require [super-app.simple-jms :as jms])
  (:import [spark Spark]))

(defn handle
  [fn] (reify spark.Route (handle [_ req res] (fn req res))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [person (person/print-person {::person/name "John" ::person/age 56 ::person/hobbies ["computer"]})]
    (do
      (Spark/get "hello" (handle (fn [req res] person)))

      (Spark/post "jms-send" (handle (fn [req res] (do
                                                     (jms/send-to-queue "my-queue" "my-message")
                                                     "OK"))))

      (Spark/post "jms-receive" (handle (fn [req res] (do
                                                        (println (str "Received: " (jms/receive-from-queue "my-queue")))
                                                        "OK"))))
      (println "Done."))))