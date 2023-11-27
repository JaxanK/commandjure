(ns commandjure.core
  (:gen-class)
  (:require [commandjure.GUI :as gui]
            [commandjure.ApplicationControls :as AppControls]
            ))



(defn -main [& _]
  (println "ProgramLaunchComplete")
  ;This will shut down program when the GUI is closed, but only when running in production. In dev it will not close the repl
  (swap! AppControls/RunningProgramState assoc :Profile :Prod)

  (gui/RenderSetupAndRun)
)



;General TODOS
; If this is stateless, then we can have multiple stdins for calling commands, doesn't need to be one command line where all input has to go through....
;Figure out how GUI calls could work as well mght be some cool code to help develop additional functionality for complex commands
; Add environment variables for controlling echo
; For alternate user inputs, call them as an alt like thing where the first to finish is what is used.