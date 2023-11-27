(ns commandjure.CommandProcessor
  (:require [commandjure.Configuration :refer [*state]]
            ))

(def continue (atom true))

(defn- processPartialInput [input]

  (cond (= input "Jax")    (swap! *state assoc :CommandLineBuffer "Totally Valid Input")
        (= input "Ryan")   (swap! *state assoc :CommandLineBuffer "Invalid Input")
        (= input "Pierce") (swap! *state assoc :CommandLineBuffer "To be determined!")))

(defn CommandLineReaderProcess []
  (while @continue
   (let [currentInput (:InputStream @*state)]
    (processPartialInput currentInput))

   (Thread/sleep 500)
  )
  (println "Command line processing stopped")
  )

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