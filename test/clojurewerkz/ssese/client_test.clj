(ns clojurewerkz.ssese.client-test
  (:require [clojure.test :refer :all]
            [clojurewerkz.ssese.client :as ssec])
  (:import [org.webbitserver WebServers WebServer]
           clojure.lang.IFn))

(def server-port 47554)

(defn ^WebServer webbit-handler
  [^String path ^IFn on-open ^IFn on-close]
  (let [^WebServer ws (WebServers/createWebServer server-port)]
    (doto ws
      (.add path (reify org.webbitserver.EventSourceHandler
                   (onOpen [this conn]
                     (on-open conn))
                   (onClose [this conn]
                     (on-close conn)))))))

(defmacro with-webbit-handler
  [^WebServer ws & body]
  `(try
     (println "Starting SSE server")
     (.start ~ws)
     (Thread/sleep 100)
     (println "Started SSE server")
     ~@body
     (finally
       (println "Stopping SSE server")
       (.stop ~ws)
       (println "Stopped SSE server"))))

;;
;; Tests
;;

(deftest test-publish-and-consume-three-single-line-messages
  (let [wh (webbit-handler "/es/*"
                           (fn [conn]
                             (println "SSE connection opened"))
                           (fn [conn]
                             (println "SSE connection closed")))]
    (with-webbit-handler wh
      (let [eh (ssec/event-handler (fn [] (println "Client connected"))
                                         (fn [^String event m]
                                           (println m))
                                         (fn [^Throwable t] (.printStackTrace t)))]
        (with-open [c  (ssec/connect (format "http://127.0.0.1:%d/es/hello?echoThis=yo" server-port)
                                     eh)]
          )))))
