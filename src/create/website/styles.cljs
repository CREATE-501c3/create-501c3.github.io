(ns create.website.styles
  (:require-macros
    [garden.def :refer [defcssfn]])
  (:require
    [spade.core   :refer [defglobal defclass]]
    [garden.units :refer [px]]))

(defglobal defaults
  [:body
   {:color            :black
    :background-color :white
    :padding          (px 10)}])

(defclass level1
  []
  {:color :navy})

(defclass create-logo-text []
  {:color       :blue
   :display     "inline-block"
   :font-size   (px 24)
   :font-weight 900
   :font-family "roboto"})

(defclass team-logo
  []
  {:min-width (px 200)})
