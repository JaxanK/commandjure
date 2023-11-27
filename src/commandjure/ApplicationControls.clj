(ns commandjure.ApplicationControls)

(def RunningProgramState (atom {:Profile :Dev}))

(defn EndProgram []
  (case (:Profile @RunningProgramState)
    :Dev nil
    :Prod (System/exit 0)
    nil))