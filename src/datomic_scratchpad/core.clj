(ns datomic-scratchpad.core
  (:require [datomic.dev-local :as dl]
            [datomic.client.api :as d]))
(def client (d/client {:server-type :dev-local
                       :system "datomic-samples"}))

(def conn (d/connect client {:db-name "movies"}))

(def db (d/db conn))


;; Get titles
(d/q '[:find ?title
       :where [_ :movie/title ?title]]
     db)
