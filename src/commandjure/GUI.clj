(ns commandjure.GUI
  (:require [cljfx.api :as fx]
            [commandjure.ApplicationControls :as AppControls]
            [commandjure.Configuration :refer [*state]]
            [commandjure.CommandProcessor :refer [RunCommand]]
            ))


    
  (defn closeGuiRequest [_] (AppControls/EndProgram))
  
  (defn root [{:keys [title showing Tabs ActiveTab WindowWidth WindowHeight InputStream CommandLineBuffer CommandLog] :as StateAtom}]
    {:fx/type :stage
     :showing showing
     :on-close-request closeGuiRequest
     :width WindowWidth
     :height WindowHeight
     :title title
     :scene {:fx/type :scene
             :root {:fx/type :v-box
                    :spacing 10
                    :children [{:fx/type :label
                                :text "Log"}
                               {:fx/type :text-area
                                :v-box/vgrow :always
                                :editable false
                                :text CommandLog}
                               {:fx/type :label
                                :text "Command Line  "}
                               {:fx/type :text-field
                                :text InputStream
                                :pref-column-count 30
                                :on-text-changed (fn [x] (swap! *state assoc :InputStream x)
                                                   
                                                   )
                                :on-action (fn [x] (swap! *state update :CommandLog #(str % "\n" InputStream) )
                                             (RunCommand InputStream)
                                             )
                                }
                               {:fx/type :label
                                :text CommandLineBuffer
                                }

                               ]}}})
  


  


  (defn RenderSetupAndRun []
   ;; Create renderer with middleware that maps incoming data - description -
   ;; to component description that can be used to render JavaFX state.
   ;; Here description is just passed as an argument to function component.
    (def renderer (fx/create-renderer
                   :middleware (fx/wrap-map-desc assoc :fx/type root)
                   ))
    (fx/mount-renderer *state renderer))
  
  
  (comment
    (RenderSetupAndRun)

    ;
    )