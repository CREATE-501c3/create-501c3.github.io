(ns create.website.views.teams
  (:require [re-com.core :as re-com :refer [at]]
            [create.website.routes :as routes]
            [create.website.styles :as styles]))

(defn frc-3206-logo []
  [:img {:src "/images/Metal_Lion.jpeg"
         :class (styles/team-logo)}])

(defn frc-3206-title []
  [re-com/title
   :src   (at)
   :label "T-Wrecks FRC 3206"
   :level :level2])

(defn frc-3206-link-to-homepage []
  [re-com/hyperlink-href
   :src    (at)
   :target "_blank"
   :label  "Homepage"
   :href   "https://www.whsactivities.org/robotics"])

(defn frc-3206-panel []
  [re-com/v-box
   :src      (at)
   :gap      "1em"
   :children [[frc-3206-logo]
              [frc-3206-title]
              [re-com/p "Established as an extra-curricular team at the Woodbury High School in 2014, this team has..."]
              [frc-3206-link-to-homepage]]])

(defn teams-panel []
  [re-com/v-box
   :src (at)
   :gap "1em"
   :children [[frc-3206-panel]]])

(defmethod routes/panels :teams-panel [] [teams-panel])
