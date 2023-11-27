(ns commandjure.GUI_Functions
  (:require [cljfx.api :as fx]
            ))

(defn Alert [& msg]
  (let [msg (reduce str msg)]
    (fx/on-fx-thread
     (fx/create-component
      {:fx/type :stage
       :showing true
       :title "Message"
       :width 500
       :height 100
       :scene {:fx/type :scene
               :root {:fx/type :v-box
                      :alignment :center
                      :children [{:fx/type :label
                                  :text msg}]}}}))
    msg))


