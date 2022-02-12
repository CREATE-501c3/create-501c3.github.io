(ns create.website.views
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com :refer [at]]
   [create.website.events :as events]
   [create.website.routes :as routes]
   [create.website.subs :as subs]
   [clojure.string :as str]))

(defn link-to-page [page]
  [re-com/hyperlink
   :src      (at)
   :label    (-> page name str/capitalize)
   :on-click #(re-frame/dispatch [::events/navigate page])])

;; header - logo and nav links
(defn header-panel []
  [re-com/h-box
   :src (at)
   :gap "1em"
   :children [[link-to-page :home]
              [link-to-page :teams]]])


;; main

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [re-com/v-box
     :src      (at)
     :height   "100%"
     :children [[header-panel]
                (routes/panels @active-panel)]]))

