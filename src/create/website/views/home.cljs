(ns create.website.views.home
  (:require
   [re-com.core :as re-com :refer [at]]
   [create.website.routes :as routes]
   [create.website.styles :as styles]))

(defn home-title []
  [re-com/title
   :src   (at)
   :label "CREATE - Creative Robotics Engineering And Technology Education Inc. 501(c)(3)"
   :level :level1
   :class (styles/level1)])

(defn home-panel []
  [re-com/v-box
   :src      (at)
   :gap      "1em"
   :children [[home-title]
              [:p "More to come."]]])

(defmethod routes/panels :home-panel [] [home-panel])
