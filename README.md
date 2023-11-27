# Commandjure

A work in progress Clojure library to facilitate the usage of a command line user repl similar to Emacs and AutoCAD command line.

Using this library can facilitate the design of a program by providing commands that call specific functions in the programs.

More information to be populated as the library is built out.

For now this is setup as an application to facilitate development and make it easy on junior devs. 

This will eventually be turned into a library and configuration instructions will be added.

Note: this is intended for intelligent users, and may not be for everyone. This might be a super user shell that only advanced users are allowed to touch.

Idea is to decrease overall program complexity at the cost of a higher learning curve to start with.

## This library is not ready for use yet! 


## Goals
1) Provide a command line interface that narrows the available selections as the user types a command name
2) Facilitate the quick calling of commands using pseudonames and history (i.e. typing "L" could autofill to the "Line" command)
3) Provide a series of useful user input functions that can be called from any function to get user input on demand. Also allow for alternate methods for user to specify data
4) Add HotKey options similar to Emacs (maybe eventually add which-key functionality)
5) Provide Scripting ability for code to be entered into command line instead of commands (i.e. when wrapped in parenthesis) 
        & add flags to command calls 
        & add scriptable function for (command _ _Pause _ _ _) for sequential user inputs to commands... 
6) Provide console for printing program messages to
7) Eventually provide more options for integrating with terminal and to become independent of GUI (i.e remove CLJFX specification)
8) Faciliate user selection of options using tab/shift-tab or arrow keys (similar to emacs)
9) Integrate environment variables to make program configuration easy
10) Expand to cljs and cljr
11) Have some fun!

## Usage

Needs clojure and java installed...

A CLJFX GUI should pop up when run with lein run

To launch the GUI in development call (gui/RenderSetupAndRun) from core.clj

## License

Copyright © 2023 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
