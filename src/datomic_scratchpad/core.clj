(ns datomic-scratchpad.core
  (:require [datomic.dev-local :as dl]
            [datomic.client.api :as d]))
(def client (d/client {:server-type :dev-local
                       :system "datomic-samples"}))
(d/create-database client {:db-name "hello-world"})
(def conn (d/connect client {:db-name "hello-world"}))
(def db (d/db conn))

