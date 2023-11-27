(ns commandjure.Configuration
  (:require [commandjure.Commands :as cmd])
  )

(def *state (atom {:title "Designer"
                   :showing true
                   :WindowWidth 500
                   :WindowHeight 500
                   :CommandMaps {:Jax      {:name "Jax"
                                            :call cmd/Jax
                                            :description "The Best Function Ever!"}
                                 :Ryan     {:name "Ryan"
                                            :call cmd/Ryan
                                            :description "I know math!"}
                                 :Pierce   {:name "Pierce"
                                            :call cmd/Pierce
                                            :description "TBD"}
                                 }

                   :InputStream ""
                   :CommandLog "This is the command line"
                   :CommandLineBuffer "Info text to appear here"}))