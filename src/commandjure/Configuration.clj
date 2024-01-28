(ns commandjure.Configuration
  (:require [commandjure.Commands :as cmd])
  )

(defn create-node []
  {:children {} :is-end-of-word false})

(defn insert-command [trie command]
  (let [command-chars (concat command [nil])]  ; Including nil to mark the end of a command
    (reduce (fn [current-trie char]
              (let [path (reduce (fn [p c] (conj p :children c)) [] command-chars) 
                    current-node (get-in current-trie path (create-node))
                    updated-node (if (= char nil)
                                   (assoc current-node :is-end-of-word true) current-node)]
                (assoc-in current-trie path updated-node)))
            trie command-chars)))

(defn init-trie [commands]
  (reduce insert-command (create-node) commands))

(def trie (atom (init-trie (cmd/get-command-names))))

(defn find-words [node prefix]
  (if (:is-end-of-word node)
    [prefix]
    (reduce-kv (fn [acc char child-node]
                 (concat acc (find-words child-node (str prefix char))))
               []
               (:children node))))

(defn autocomplete [trie prefix]
  (let [start-node (reduce (fn [current-node char]
                             (get-in current-node [:children char])) 
                           trie prefix)]
    (find-words start-node prefix)))

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