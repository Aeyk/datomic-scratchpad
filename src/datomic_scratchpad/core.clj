(ns datomic-scratchpad.core
  (:require [datomic.dev-local :as dl]
            [datomic.client.api :as d]))

(def client (d/client {:server-type :dev-local
                       :system "datomic-samples"}))

(d/list-databases client {})
