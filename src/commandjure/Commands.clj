(ns commandjure.Commands
  (:require [commandjure.GUI_Functions :as guifns]))

(defn Jax []
  (guifns/Alert "Jax command Successful!" ))

(defn Ryan []
  (guifns/Alert "2 + 2 is " (+ 2 2)))

(defn Pierce []
  (guifns/Alert "Change this text to achieve immortality")
  )

(defn JohnnyCage []
  (guifns/Alert "Fatality"))

(def commands
  {
   "Jax" Jax
   "Ryan" Ryan
   "Pierce" Pierce
   "Johnny Cage" JohnnyCage
   }
  )

(defn get-command-names []
  (keys commands))
