`⌘` - command  
`⌥` - option / ALT  
`⌃` - control / CTRL  
`⇧` - shift  
`↑` - up arrow  
`↓` - down arrow  
`→` - right arrow  
`←` - left arrow  
`⏎` - ENTER / RETURN  
`⌫` - backspace  
`LMB` - left mouse button

## 0. Introduction

## 1. Before we start

- `CMD , > Presentation Assistant`
- `Keymap > Based on the macOS keymap`
- `Font > Size > 15`  
[X] - `Enable ligatures!`
- `Resolution - Scaled (1600x900)`

## 2. Basic Navigation

`⌘ ⇧ \` - `Go to endpoint`
`⌘ ⌥ ⇧ E` - `Navigate > Text` 
`⌘ O` - `Go to class` - with exact line - `StringUtils:1500`  
`⌘ ⇧ O` - `Go to file`  
`⌘ ⌥ O` - `Go to symbol` - Filter with namespace - `String.contains`
`⌘ ⇧ A` - `Find action` - Find any action that you can use in IDE  
`⇧ ⇧` - `Search Everywhere`

`⌥ ↑ OR ↓` - (in above windows) browse search history

`⇧ ⇧` -> 2+2*2

## 3. Switching between windows

`⌘ ⇧ F12` - `Hide All Windows` / `Restore All Windows`

`Enter Distraction Free Mode`

`⌘ ⇧ 1` - `Select File in Project View`

`⌘ E` - `Recent files`  
`⌘ ⇧ E` - `Recent Locations`

`⌘ 1` - `Project`   
`⌘ 4` - `Run`  
`⌘ 5` - `Debug`

Use `ESCAPE` to go back from tool window to editor.

`⌃ ⌥ ← / →` - `Stretch (tool window) to Left / Right`

Use it to adjust width and height of any other tool window, for example `Recent Files`

Assign shortcut to any tool window from `Recent Files` (find it via `⌘ A`).

## 4. Assign new shortcut

`⌘ ⇧ A` - find `Gradle` and assign new shortcut with `⌥ ⏎`

`⌘ ,` - `Keymap`

`⌃ ⌃` - Run Anything (Gradle, Apprunner, any configuration)

## 5. Tabs vs no tabs

`⌘ ,` - `Editor tabs` - `Change to 'none'`

## 6. Scratch file

### a. New Scratch file

`⌘ ⇧ N` - `Scratch file`

Copy `curl.txt` and paste into `.http` scratch. Edit and then export as new cURL.

Scratch files are not detected by git. You can always create `.http` file in your project directory and keep it in git.

## 7. Navigating inside file

### a. File Structure, Next Highlighted Error, Go to Line

`⌘ F12` - `File Structure`  
`⌘ L` - `Go to Line:Column`  
`F2` - `Next Highlighted Error`

### b. Next Highlighted Usage

`⌃ ⌥ ↑/↓` - `Next Highlighted Usage` - use instead `⌘ B`

### c. Next / previous method

`⌃ ⇧ ↑` - `Previous Method`

`⌃ ⇧ ↓` - `Next Method`

### d. Last Edit Location

`⌘ ⌥ ← / →` OR `⌘ ] / [` `Nagivate > Back / Forward`  
`⌘ ⇧ ⌫` - `Navigate > Last Edit Location`

### e. Annotate

`Find Action` - `Git | Current File: Annotate with Git Blame`

## 8. Editing a file

`StringUtils:1500`

### a. Expand / collapse comments

`⌘ ⇧ A` - Type 'collapse' and choose `Collapse Doc Comments`




### b. Extend selection. Duplicating, deleting lines, Paste from history

`⌘ ↑` - `Extend selection`  
`⌘ ↓` - `Shrink selection`.

`⌘ ⇧ V` - `Paste from history`

`⌘ D` - `Duplicate Line`  
`⌘ ⌫` - `Delete Line`

`⌘ /` - `Comment with Line Comment`  
`⌘ ⌥ /` - `Comment with Line Comment`

### c. Moving lines, statements

`⌘ ⇧ ↓ OR ↑` - `Move Statement Up / Down`

`⌥ ⇧ ↓ OR ↑` - `Move Line Up / Down`

### d. Multi-line cursor, select all occurrences

`⌥ + ⌥ + ↓ / ↑` - `Clone Caret Below / Above`

`⌃ ⌘ G` - `Select All Occurrences`

`⌥ SIFT + LMB` - Add cursor in clicked place`

### e. Replace (in Files)

`⌘ R` - `Replace`  
`⌘ ⇧ R` - `Replace in Files`

Use it in `Project` view, to run optimizer on a whole directory:  
`⌘ ⌥ L` - `Reformat Code`  
`⌃ ⌥ O` - `Optimize Imports`

### h. Live templates, Surround with, Complete current Statement

`spgwt` - `Spock: given - when - then`

`⌘ ⌥ T` - `Surround With`

`⌘ ⇧ ⏎` - `Complete Current Statement`

## 9. Refactoring

`⌃ T` - `Refactor This` and choose what you need

- `⌘ ⌥ M` - `Extract Method`
- `⌘ ⌥ C` - `Extract Constant` (twice for more options => hold ⌥ and press highlighted characters on keyboard)
- `⌘ ⌥ V` - `Extract Variable`
- `⌘ ⌥ N` - `Inline`

More refactor tools is in `Refactor` menu. Check difference between Java and Kotlin options.

## 10. Additionally

- `Search Structurally`
- `Help > Search`
- `Help > Keymap Shortcuts PDF`
- `Help > IntelliJ IDEA on YouTube`
- `Help > My Productivity`
- `Help > Change memory settings`

https://blog.jetbrains.com/kotlin/2021/06/simple-steps-for-improving-your-ide-performance/

https://blog.jetbrains.com/idea/2021/08/10-places-you-don-t-need-to-use-the-mouse-in-intellij-idea

http://courses.ics.hawaii.edu/ics314s17/morea/development-environments/reading-intellij-macos-configuration.html

https://www.youtube.com/user/intellijideavideo

https://itectec.com/askdifferent/macos-how-to-disable-the-minimize-command-m-shortcut-in-mavericks

Plugins:
- Presentation Assistant
- Spock Framework Enhancements
- Key Promoter X
