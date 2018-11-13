(defproject super-app "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.sparkjava/spark-core "2.8.0"]
                 [org.apache.activemq/activemq-core "5.7.0"]
                 [org.clojure/core.async "0.4.474"]]
  :aot :all
  :main super-app.core
  :target-path "target/%s"
  :profiles {:dev {:dependencies [[midje "1.6.3"]]}})
