(defproject clojurewerkz/ssese "1.0.0-SNAPSHOT"
  :description "Clojure Server-Sent Events (SSE) client"
  :dependencies [[org.clojure/clojure       "1.6.0"]
                 [io.opensensors/sse-client "1.0.0-SNAPSHOT"]]
  :profiles {:1.7    {:dependencies [[org.clojure/clojure "1.7.0-alpha3"]]}
             :master {:dependencies [[org.clojure/clojure "1.7.0-master-SNAPSHOT"]]}
             :dev {:resource-paths ["test/resources"]
                   :plugins [[codox "0.8.10"]]
                   :dependencies [[org.webbitserver/webbit "0.4.15"]]
                   :codox {:sources ["src/clojure"]
                           :output-dir "doc/api"}}}
  :aliases {"all" ["with-profile" "dev:dev,1.7:dev,master"]}
  :repositories {"sonatype" {:url "http://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail}}
                 "sonatype-snapshots" {:url "http://oss.sonatype.org/content/repositories/snapshots"
                                       :snapshots true
                                       :releases {:checksum :fail :update :always}}}
  :javac-options      ["-target" "1.6" "-source" "1.6"]
  :jvm-opts           ["-Dfile.encoding=utf-8"]
  :source-paths       ["src/clojure"]
  :java-source-paths  ["src/java"]
  :global-vars {*warn-on-reflection* true})
