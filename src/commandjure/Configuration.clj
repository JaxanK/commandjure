(ns commandjure.Configuration
  (:require [commandjure.Commands :as cmd])
  )

(defn create-node []
  {:children {} :is-end-of-word false})

(defn insert-command [trie command]
  (reduce (fn [node char]
            (let [child (get-in node [:children char] (create-node))]
              (assoc-in node [:children char] child)))
          trie (concat command [nil])))

(defn init-trie [commands]
  (reduce insert-command (create-node) commands))

(def trie (atom (init-trie (cmd/get-command-names))))

(defn autocomplete [node prefix]
  (let [find-words (fn find-words [node prefix]
                     (if (:is-end-of-word node)
                       [prefix]
                       (reduce-kv (fn [acc char child-node]
                                    (concat acc (when char (find-words child-node (str prefix char)))))
                                  []
                                  (:children node))))]
    (find-words (get-in node [:children] prefix) prefix)))

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