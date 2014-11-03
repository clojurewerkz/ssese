(ns clojurewerkz.ssese.client
  (:require [clojurewerkz.ssese.conversion :as cnv])
  (:import [io.opensensors.sse.client EventSource EventSourceHandler MessageEvent]
           java.net.URI
           clojure.lang.IFn
           java.util.concurrent.Executors))

;;
;; Implementation
;;

(defprotocol URIEndpoint
  (^URI to-uri [arg] "Coerces the argument to a URI"))

(extend-protocol URIEndpoint
  URI
  (to-uri [uri]
    uri)

  String
  (to-uri [uri]
    (URI. uri)))



;;
;; API
;;

(defn event-handler
  ([^IFn on-message]
     (event-handler nil on-message nil))
  ([^IFn on-connect ^IFn on-message ^IFn on-error]
     (reify EventSourceHandler
       (^void onConnect [this]
         (when on-connect
           (on-connect)))
       (^void onMessage [this ^String event ^MessageEvent msg]
         (when on-message
           (on-message event (cnv/message-event->map msg))))
       (^void onError [this ^Throwable t]
         (when on-error
           (on-error t))))))

(defn ^EventSource connect
  ([uri ^EventSourceHandler handler]
     (connect uri handler {}))
  ([uri ^EventSourceHandler handler opts]
     (let [es (EventSource. (get opts :executor (Executors/newSingleThreadExecutor))
                   (get opts :reconnection-time-millis EventSource/DEFAULT_RECONNECTION_TIME_MILLIS)
                   (to-uri uri)
                   handler)]
       (doto es .connect))))
