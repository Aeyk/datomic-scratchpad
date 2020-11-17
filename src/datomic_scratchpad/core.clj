(ns datomic-scratchpad.core
  (:require [datomic.dev-local :as dl]
            [datomic.client.api :as d]
            [mount.core :as mount]))

(def db-name "movies") ;; todo maybe put this in (env :config) thing

(mount/defstate *datomic*
  :start
  (fn [conn]
    (def client
      (d/client
       {:server-type :dev-local
        :system "datomic-samples"}))
    (def conn (d/connect client {:db-name db-name}))
    (def *datomic-db* (d/db conn)) *datomic-db*)
  :stop
  (fn [conn]
    (.release conn)))

(d/list-databases client {})

;; Get titles
(d/q '[:find ?movie
       :where [?movie :movie/title _]]
     *datomic-db*)

;; Get entries from 1984
(d/q '[:find ?movie ?title
       :where
       [?movie :movie/release-year 1984]
       [?movie :movie/title ?title]]
     db)


(d/q '[:find ?name
       :where
       [?person :person/name ?name]]
     db)
