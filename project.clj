(defproject commandjure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  

  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/core.async "1.6.673"]
                 [org.flatland/ordered "1.15.11"]
                 

                 ;GUI
                 [cljfx "1.7.22"]
                 [cljfx/css "1.1.0"]
                 ]
  :repl-options {:init-ns commandjure.core}

  :main ^:skip-aot commandjure.core ;Use for testing, will probably want to remove once library is to be released
  )
