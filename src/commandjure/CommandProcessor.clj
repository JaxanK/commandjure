(ns commandjure.CommandProcessor
  (:require [commandjure.Configuration :refer [*state autocomplete trie]]
            ))

(def continue (atom true))

(defn process-input [input]
  (let [completions (autocomplete @trie input)]
    ;; Not sure if swap! *state assoc will work in this case
    (swap! *state assoc :CommandLineBuffer "Completions:" completions)))

;; Swapped this part out - using a dictionary in Commands.clj
;; (defn- processPartialInput [input]

;;   (cond (= input "Jax")    (swap! *state assoc :CommandLineBuffer "Totally Valid Input")
;;         (= input "Ryan")   (swap! *state assoc :CommandLineBuffer "Invalid Input")
;;         (= input "Pierce") (swap! *state assoc :CommandLineBuffer "To be determined!")))

(defn CommandLineReaderProcess []
  (while @continue
    (let [currentInput (:InputStream @*state)]
      (when (not (empty? currentInput))
        (process-input currentInput)
        (swap! *state assoc :InputStream "")) ; Clear Input after Processing
      (Thread/sleep 500)))
  (println "Command line processing stopped"))

(defn startCommandLineProcess []
  (reset! continue true)

  (future (CommandLineReaderProcess))
)
(defn stopCommandLineProcess []
  (reset! continue true)

  )
(stopCommandLineProcess)
(startCommandLineProcess)

(defn RunCommand [cmdname]
  
  ;Check if valid command
  (let [cmdkey (keyword cmdname)
        cmdmap (:CommandMaps @*state)]
    (if ((set (keys cmdmap))  cmdkey)
      ((:call (cmdkey cmdmap))))))