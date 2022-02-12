(ns create.website.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [create.website.events :as events]
   [create.website.routes :as routes]
   [create.website.views :as views]
   [create.website.views.teams]
   [create.website.config :as config]))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (routes/start!)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
