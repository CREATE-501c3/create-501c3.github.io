(ns create.website.views.home
  (:require
   [re-com.core :as re-com :refer [at]]
   [create.website.routes :as routes]
   [create.website.styles :as styles]))

(defn about-content []
  [:<>
   [:p "Creative Robotics Engineering And Technology Education Inc. (CREATE) is organized exclusively for charitable,
   educational, and scientific purposes within the meaning of Section 501(c)(3) of the Internal Revenue Code of 1986, as
   amended."]
   [:p "The purpose of this corporation is:"]
   [:ul
    [:li "To promote, support and encourage Science, Technology, Engineering and Math (STEM) clubs."]
    [:li "To facilitate grant writing and encourage corporate donations to address financial needs of STEM clubs."]
    [:li "To encourage mentor and parent involvement with STEM clubs."]
    [:li "To collaborate with schools to make purchases for the benefit of STEM clubs."]]
   [:p "STEM clubs include extra-curricular programs and robotics teams for school-age youth."]])

(defn home-title []
  [re-com/title
   :src   (at)
   :label "CREATE"
   :level :level1
   :class (styles/level1)])

(defn home-panel []
  [re-com/v-box
   :src      (at)
   :gap      "1em"
   :children [[home-title]
              ;; TODO: Image carrosel
              [about-content]]])

(defmethod routes/panels :home-panel [] [home-panel])
