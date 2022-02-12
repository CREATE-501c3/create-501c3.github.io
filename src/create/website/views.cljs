(ns create.website.views
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com :refer [at]]
   [create.website.events :as events]
   [create.website.routes :as routes]
   [create.website.subs :as subs]
   [create.website.styles :as styles]
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

;; home

(defn about-content []
  [re-com/box
   :src   (at)
   :child [:<>
           [:p "Creative Robotics Engineering And Technology Education Inc. (CREATE) is organized exclusively for
                  charitable, educational, and scientific purposes within the meaning of Section 501(c)(3) of the
                  Internal Revenue Code of 1986, as amended."]
           [:p "The purpose of this corporation is:"]
           [:ul
            [:li "To promote, support and encourage Science, Technology, Engineering and Math (STEM) clubs."]
            [:li "To facilitate grant writing and encourage corporate donations to address financial needs of STEM clubs."]
            [:li "To encourage mentor and parent involvement with STEM clubs."]
            [:li "To collaborate with schools to make purchases for the benefit of STEM clubs."]]
           [:p "STEM clubs include extra-curricular programs and robotics teams for school-age youth."]]])

(defn home-title []
  [re-com/title
   :src   (at)
   :label "CREATE"
   :level :level1
   :class (styles/level1)])

(defn banner []
  [re-com/box
   :src (at)
   :child [:img {:src "images/FRC-3206-2020.jpg"}]])

(defn home-panel []
  [re-com/v-box
   :src      (at)
   :gap      "1em"
   :children [[home-title]
              [banner]
              [about-content]]])

(defmethod routes/panels :home-panel [] [home-panel])

;; main

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [re-com/v-box
     :src      (at)
     :height   "100%"
     :children [[header-panel]
                (routes/panels @active-panel)]]))

