(ns clojurewerkz.ssese.conversion
  "Functions that convert Java SSE client objects to immutable Clojure data structures."
  (:import [io.opensensors.sse.client MessageEvent]
           clojure.lang.IPersistentMap))

;;
;; API
;;

(defn ^IPersistentMap message-event->map
  [^MessageEvent evt]
  {:origin (. evt origin)
   :data   (. evt data)
   :last-event-id (. evt lastEventId)})
