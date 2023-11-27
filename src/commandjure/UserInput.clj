(ns commandjure.UserInput)


(defn prompt-start "Print promptStr to the terminal and wait for PromptEnd to be called before allowing more user input"   [promptStr])
(defn prompt-end   "Print promptEndStr to the terminal (if defined) and end prompt to allow for next command" [promptEndStr])

(defn prompt-till-promise-derefs "starts a prompt and returns a promise that when set will call (prompt-end @prom)" [promptStr]
  (prompt-start promptStr)
  (let [prom (promise)]
    (future (let [pr @prom]
              (if (string? pr)
                (prompt-end @prom)
                (prompt-end "Done"))))
    prom))


(defn getint   "Get an integer from the user using promptStr as instruction"  [promptStr] 
  ;Correct promptStr with a default string if a string is not supplied
  (let [promptStr (if (string? promptStr) promptStr "Please enter an integer: " )] 
    ;Code here
  ))
    
(defn getreal     "Get a real # from the user using promptStr as instruction"    [promptStr])
(defn getstring   "Get a string from the user using prompStr as instruction"     [promptStr])
(defn getpoint-3D "Get an X, Y, and Z from user using prompStr as instruction"   [promptStr])
(defn getpoint-2D "Get an X and Y from user using prompStr as instruction"       [promptStr])
(defn getkeyword  "Get a keyword from user using promptStr as instruction"       [promptStr]
  ;This function should not allow whitespace to be entered and will look something like (keyword (getstring ...))
  ;You will need to think about the best way to solve this without duplicating code
  )

(defn getoption "Gets a user selection from provided options.
                 If a list/vector/set, will return the value of the selection
                 If a map will return the key of the selection
                 "
  [promptStr options]
        ;Design question: How will the user specify which option to use? 
        ; Narrow down the list as they type...
        ; use tab/shift-tab or the arrow keys (like emacs does it) to select which ones you are picking from the list...
  )




; |---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
; |     Extensions later    
; |---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

;Unit Conversions
(defn getdistance "Gives user option to enter a distance using different units and function will return the distance converted to units specified in unitToReturn" 
  [promptStr unitToReturn])

(defn getdistance-inch   [promptStr] (getdistance promptStr :inch))
(defn getdistance-meters [promptStr] (getdistance promptStr :meters))
;...

(defn getangle [promptStr unitToReturn])
(defn getangle-rad [promptStr] (getangle promptStr :rad))
(defn getangle-deg [promptStr] (getangle promptStr :deg))
;Feel free to add any others that might be useful




;Default Value on enter press
;  if user enters nothing (as in they just hit enter) add ability to specify the default value to return
;      add option to prevent a default value and loop until user enters something valid


;Spec Check Optional Argument
;  Add optional argument for a spec check. If spec fails, it should be printed to the command line.
;      Jax Note: might want to add library option for making spec even more human readable... not sure how we would do this without adding an external dependency though...

;"OR" option like Initget keywords in AutoLISP
;   Add option for "or" so that you can for example call getint but then give user the option to select an option instead
;   Could this just be an extension of the spec argument somehow? Maybe a modified getoption...

;Provide option to call a GUI with a promise? That could work pretty well I think...




