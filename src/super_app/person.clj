(ns super-app.person
  (:require [clojure.spec.alpha :as s]))

(s/def ::age int?)
(s/def ::name string?)
(s/def ::hobby string?)
(s/def ::hobbies (s/coll-of ::hobby))
(s/def ::person (s/keys :req [::name ::age ::hobbies]))

(defn print-person
  [person] {:pre [(s/valid? ::person person)] :post [(s/valid? string? %)]} (str person))